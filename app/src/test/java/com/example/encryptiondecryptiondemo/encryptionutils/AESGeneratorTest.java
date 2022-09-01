package com.example.encryptiondecryptiondemo.encryptionutils;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AESGeneratorTest {
    @Test
    public void EncryptionThenDecryptionGivesOriginalText()
            throws NoSuchAlgorithmException, NoSuchProviderException,
                   InvalidAlgorithmParameterException, NoSuchPaddingException,
                   IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // initialise SecretKey, IvParameterSpec, and algorithm for encrypt and decrypt.
        SecretKey key = null;
        try {
            key = AESGenerator.generateKey(128);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        IvParameterSpec ivParameterSpec = AESGenerator.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String plainText = "lorem ipsum";
        String cipherText = null;

        cipherText = AESGenerator.encrypt(algorithm, plainText, key, ivParameterSpec);

        // Asserts that plain text has been transformed into cipher text.
        Assert.assertNotEquals(plainText, cipherText);

        String newPlainText = AESGenerator.decrypt(algorithm, cipherText, key, ivParameterSpec);

        // Asserts that encrypting plain text into cipher text, then decrypting that cipher text...
        // ... returns the original plain text.
        Assert.assertEquals(plainText, newPlainText);
    }
}
