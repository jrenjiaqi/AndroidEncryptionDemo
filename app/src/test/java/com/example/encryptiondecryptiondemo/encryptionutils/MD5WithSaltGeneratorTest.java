package com.example.encryptiondecryptiondemo.encryptionutils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class MD5WithSaltGeneratorTest {

    // ensure randomly generated salt do not collide (extremely unlikely to).
    @Test
    public void saltNonCollisionTest() throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] firstSalt = MD5WithSaltGenerator.getSalt();
        byte[] secondSalt = MD5WithSaltGenerator.getSalt();
        // assert salts are not equal.
        Assert.assertNotEquals(firstSalt, secondSalt);
    }

    // ensure one-way encryption works.
    @Test
    public void oneWayEncryptionTest() throws NoSuchAlgorithmException, NoSuchProviderException {
        String plainText = "P@ssword123";
        String cipherText = null;
        byte[] salt = MD5WithSaltGenerator.getSalt();
        cipherText = MD5WithSaltGenerator.getSecurePassword(plainText, salt);
        // assert is not null (i.e. no exceptions from encryption above).
        Assert.assertNotNull(cipherText);
        // assert cipherText is different from plainText.
        Assert.assertNotEquals(plainText, cipherText);
    }
}