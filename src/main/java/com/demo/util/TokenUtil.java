package com.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

/**
 * @author 32050
 */
public class TokenUtil {

    private static final long EXPIRE_TIME = 10*60*60*1000;
    private static final String TOKEN_SECRET = "A+";

    /**
     * 用于签发Json Web Token
     * @param username 用户名
     * @return 返回Token
     */
    public static String sign(String username) {
        String token = null;
        try {
            Date expireAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", username)
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 用于验证Token的正确性
     * @param token token
     * @return 返回验证后的Token，如果没有通过，则返回null
     */
    public static DecodedJWT verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            jwt.getClaim("username").asString();
            jwt.getExpiresAt();
            return jwt;
        } catch (Exception e) {
            return null;
        }
    }

}
