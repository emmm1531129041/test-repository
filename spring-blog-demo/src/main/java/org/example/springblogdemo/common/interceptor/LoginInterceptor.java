package org.example.springblogdemo.common.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.springblogdemo.common.util.JwtUtils;
import org.example.springblogdemo.pojo.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //使用response 设置http body 内容时, 需要设置编码
        response.setContentType("application/json;charset=utf-8");
        //从header中获取token
        String jwtToken = request.getHeader("User-Token");
//        log.info("从header中获取token: {}", jwtToken);
        //校验token
        Claims claims = JwtUtils.parseJwt(jwtToken);
        if (claims==null){
            log.error("令牌校验失败, token:{}", jwtToken);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getOutputStream().write(objectMapper.writeValueAsString(Result.fail("用户未登录")).getBytes(StandardCharsets.UTF_8));
            return false;
        }
        log.info("令牌校验通过");
        return true;
    }
}

