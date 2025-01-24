package com.quanxiaoha.weblog.jwt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wanghaibin
 * @url: www.quanxiaoha.com
 * @date: 2023-04-18 16:21
 * @description: 登录认证过滤器
 **/
public class JwtAuthenticationLoginFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 设置登录认证的访问地址
     */
    public JwtAuthenticationLoginFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(request.getInputStream());
        String username = jsonNode.get("username").textValue();
        String password = jsonNode.get("password").textValue();

        PasswordEncoder pw = new BCryptPasswordEncoder();
        //每次加密的结果可能不同
        String encode = pw.encode(password);

        // 将用户名、密码封装到 Token 中
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
    }
}
