package org.example.springblogdemo.common.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static final long Expiration = 7 * 24 * 60 * 60 * 1000;  //7天
    private static final String secretString = "rXRoWn8J+bCcnadUFU88AIqhK9caLJCg+6c2rP8F1EE=";
    private static final Key key = Keys.hmacShaKeyFor(secretString.getBytes());
    /**
     * 生成令牌
     */
    public static String genJwt(Map<String, Object> claim){
        return Jwts.builder().setClaims(claim)  //自定义的内容
                .setIssuedAt(new Date()) //设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + Expiration))   //有效期
                .signWith(key)//签名算法
                .compact();
    }

    /**
     * 校验令牌
     */
    public static Claims parseJwt(String jwt){
        if (!StringUtils.hasText(jwt)){
            return null;
        }
        //创建解析器, 设置签名密钥
        JwtParserBuilder jwtParserBuilder = Jwts.parserBuilder().setSigningKey(key);
        //解析token
        Claims claims = null;
        try {
            claims = jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
        }catch (Exception e){
            log.warn("解析令牌失败, jwt:{}", jwt);
        }
        return claims;
    }
}

