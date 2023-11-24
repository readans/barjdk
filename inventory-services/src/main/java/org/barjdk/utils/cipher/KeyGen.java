package org.barjdk.utils.cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyGen {
    public static void main(String[] args) {
        try {
            // Usar el algoritmo HMAC con SHA-256 (puedes elegir otro algoritmo si lo deseas)
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");

            // Generar una clave secreta de 256 bits
            SecretKey secretKey = keyGen.generateKey();

            // Imprimir la clave secreta como una cadena Base64
            String base64Key = java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Secret Key: " + base64Key);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
