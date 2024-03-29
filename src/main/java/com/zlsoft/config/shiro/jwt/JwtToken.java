package com.zlsoft.config.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JwtToken
 * @author dp926454
 * @date 2018/8/30 14:06
 */
public class JwtToken implements AuthenticationToken {
    /**
     * Token
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
