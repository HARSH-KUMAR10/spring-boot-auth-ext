package com.harshkumar093.jpa.annotation;

import com.harshkumar093.jpa.extension.JwtExtension;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RequireJwtAspect {
    @Autowired
    JwtExtension jwtExtension;
    @Before("@annotation(RequireJwt)")
    public void validateJwt(JoinPoint joinPoint){
        String token = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("Authorization");
        jwtExtension.validateJwt(token.split(" ")[1]);
    }
}
