 package com.quanxiaoha.weblog.web;

 import org.junit.Test;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;

 @SpringBootTest
 class WeblogWebApplicationTests {

     @Test
     void contextLoads() {
         PasswordEncoder pw = new BCryptPasswordEncoder();
         //每次加密的结果可能不同
         String encode = pw.encode("123");
         System.out.println(encode);
         //比较密码,springsecurit能记录每次随机的盐值
         boolean matches = pw.matches("123", encode);
         System.out.println(matches);
     }

 }
