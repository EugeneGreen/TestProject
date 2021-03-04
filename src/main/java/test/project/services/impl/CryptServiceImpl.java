package test.project.services.impl;

import org.springframework.stereotype.Service;
import test.project.services.CryptService;

import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class CryptServiceImpl implements CryptService {
    private SecretKey secretKey;

    public CryptServiceImpl() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            this.secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encryptMessage(String message) {
        byte[] output = cryptMessage(message.getBytes(), Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(output);
    }

    public String decryptMessage(String message) {
        byte[] input = Base64.getDecoder().decode(message);
        byte[] output = cryptMessage(input, Cipher.DECRYPT_MODE);
        return new String(output);
    }

    private byte[] cryptMessage(byte[] bytes, int mode) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, this.secretKey);
            byte[] result = cipher.doFinal(bytes);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
