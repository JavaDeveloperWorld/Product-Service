package com.example.village.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = LogManager.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        User principal = (User) authentication.getPrincipal();
        boolean isAdmin = false;
        boolean isUser = false;
        Iterator<GrantedAuthority> grantedAuthorityIterator = principal.getAuthorities().iterator();
        while (grantedAuthorityIterator.hasNext()) {
            String role = grantedAuthorityIterator.next().getAuthority();
            if (role.equalsIgnoreCase("ROLE_ADMIN")) {
                isAdmin = true;
            }
            if (role.equalsIgnoreCase("ROLE_USER")) {
                isUser = true;
            }
        }
        if (isAdmin) {
            response.sendRedirect("/adminView");
        } else if (isUser) {
            response.sendRedirect("/userDashboard");
        } else {
            response.sendError(1);
        }
    };


}