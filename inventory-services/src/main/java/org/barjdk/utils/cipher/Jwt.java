package org.barjdk.utils.cipher;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Component
@Slf4j
public class Jwt {

    @Value("${cipher.secret-key.path}")
    private String keyFilePath;

    private String secretKey;

    public String encrypt(String payload) {
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        String token = JWT.create()
                .withPayload(payload)
                .sign(algorithm);
        return token;
    }

    public String decrypt(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        byte[] decodedBytes = Base64.getDecoder().decode(verifier.verify(token).getPayload());
        return new String(decodedBytes);
    }

    @PostConstruct
    public void init() throws Exception{
        // Leer la clave desde el archivo
        secretKey = new String(Files.readAllBytes(Paths.get(keyFilePath))).trim();
    }
}
