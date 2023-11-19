package com.aoyu.software_library.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.utils
 * @Author: AoYu
 * @CreateTime: 2023-11-15  21:50
 * @Description: 生成token工具类
 * @Version: 1.0
 */

public class JwtTokenUtil {
    private static final String SECRET_KEY = "aoyu546413482488"; // 用于签名的密钥
    private static final long EXPIRATION_TIME = 86400000; // 过期时间，单位：毫秒（这里是一天）

    public static String generateToken( Map<String, Object> claims) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        return JWT.create()
                .withIssuedAt(now)
                .withExpiresAt(expiration)
                .withClaim("claims", claims) // 可以添加自定义的声明
                .sign(algorithm);
    }

    public static Map<String, Object> decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

}
