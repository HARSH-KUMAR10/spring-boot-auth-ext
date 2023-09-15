package com.harshkumar093.jpa.annotation;
import com.harshkumar093.jpa.config.JwtConfig;
import com.harshkumar093.jpa.extension.JwtExtension;
import com.harshkumar093.jpa.model.role.Roles;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Aspect
@Component
public class RequireRoleAspect {

    @Autowired
    JwtExtension jwtExtension;
    @Before("@annotation(requireRole)")
    public void checkRoleAccess(JoinPoint joinPoint, RequireRole requireRole) {
        String token = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("Authorization");
        List<Roles> roles = jwtExtension.getRolesFromJwt(token.split(" ")[1]);
        boolean isForbidden = true;
        for(String annotationRole: requireRole.value()){
            for(Roles jwtRole: roles){
                if(annotationRole.equals(jwtRole.getRole())){
                    isForbidden=false;
                    break;
                }
            }
        }
        if(isForbidden){
            throw new ForbiddenResourceException(403,"Forbidden resource");
        }
    }
}