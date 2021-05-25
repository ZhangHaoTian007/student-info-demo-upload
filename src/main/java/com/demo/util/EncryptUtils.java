package com.demo.util;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 32050
 * 该类用于哈希算法加密用于保存密码
 */
public class EncryptUtils {
    public static String encrypt(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            return new BigInteger(1, digest).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
