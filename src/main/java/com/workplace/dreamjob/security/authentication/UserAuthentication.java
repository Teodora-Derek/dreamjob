package com.workplace.dreamjob.security.authentication;

import com.workplace.dreamjob.security.model.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record UserAuthentication(AuthUser authUser) implements Authentication {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(authUser.role())
                .stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return authUser;
    }

    @Override
    public boolean isAuthenticated() {
        // This value is set to true because Authentication is used only to represent
        // an authenticated user and not for transferring authentication details
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // NoOp
    }

    @Override
    public String getName() {
        return null;
    }
}
