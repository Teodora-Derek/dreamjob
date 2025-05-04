package com.workplace.dreamjob.security.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.workplace.dreamjob.common.Role;
import com.workplace.dreamjob.security.exception.TokenAuthenticationException;
import com.workplace.dreamjob.security.user.AuthUser;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String ROLES_CLAIM = "roles";

    private final Algorithm signingAlgorithm;
    private final long expirationTime;

    public JwtService(@Value("${jwt.secret}") String signingSecret,
            @Value("${jwt.expiration}") long expirationTime) {

        // use a symmetric signature of the JWT token for simplicity
        this.signingAlgorithm = Algorithm.HMAC256(signingSecret);
        this.expirationTime = expirationTime;
    }

    public AuthUser resolveJwtToken(String token) {

        try {
            JWTVerifier verifier = JWT.require(signingAlgorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            String userId = decodedJWT.getSubject();
            Role role = decodedJWT.getClaim(ROLES_CLAIM).asList(Role.class).get(0);

            return new AuthUser(userId, role);
        } catch (JWTVerificationException exception) {
            throw new TokenAuthenticationException("JWT is not valid");
        }
    }

    public String createJwtToken(AuthUser authUser) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + expirationTime; // 1 hour validity
        Date exp = new Date(expMillis);

        List<String> roles = List.of(authUser.role().name());

        return JWT.create().withSubject(authUser.userId()).withClaim(ROLES_CLAIM, roles)
                .withIssuedAt(now).withExpiresAt(exp).sign(signingAlgorithm);
    }
}
