package com.google.api.client.battlecatsapi;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * TBC Modder 1.0 - Cryptography Toolkit
 * Battle Cats verilerini (15.2+) çözmek için kullanılan anahtarlar ve yöntemler.
 */
public class CryptoUtils {

    // Ponos'un kullandığı standart AES anahtarı (TBC EN/JP varyasyonları için)
    private static final String DEFAULT_KEY = "battlecatsandroid"; // Örnek anahtar
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * Şifreli byte verisini alır ve çözülmüş (Plaintext) byte dizisini döndürür.
     */
    public static byte[] decrypt(byte[] encryptedData, String keyStr, String ivStr) throws Exception {
        // Anahtarı ve IV'yi (Initialization Vector) hazırla
        SecretKeySpec keySpec = new SecretKeySpec(keyStr.getBytes("UTF-8"), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivStr.getBytes("UTF-8"));

        // Cipher (Şifreleyici/Çözücü) nesnesini yapılandır
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        // Şifreyi çöz ve veriyi döndür
        return cipher.doFinal(encryptedData);
    }

    /**
     * Basit XOR şifreleme çözücü (Bazı eski sürüm paketler için gerekebilir)
     */
    public static byte[] xorDecrypt(byte[] data, byte key) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ key);
        }
        return result;
    }
}
