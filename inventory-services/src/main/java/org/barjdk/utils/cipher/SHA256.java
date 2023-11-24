package org.barjdk.utils.cipher;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class SHA256 {

    public static String getHash(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Calcular el hash del mensaje
            byte[] hashBytes = md.digest(msg.getBytes());

            // Convertir el hash a formato hexadecimal
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashBytes) {
                hexHash.append(String.format("%02x", b));
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
