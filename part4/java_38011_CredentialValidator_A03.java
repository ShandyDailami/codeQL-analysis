import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;

@Provider
public class java_38011_CredentialValidator_A03 implements ContainerRequestFilter {

    private final static Key signingKey =
            new org.apache.tomcat.util.security.SecurityUtil
                    .createMessageDigestSigningKey("52Pqw26Lf9B1g2N3Y46T67U9C1Z2S3J5");

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authorizationHeader = requestContext.getHeaderString("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ResponseException(Response.Status.UNAUTHORIZED);
        }

        String token = authorizationHeader.substring("Bearer ".length());

        try {
            Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token);
        } catch (Exception e) {
            throw new ResponseException(Response.Status.UNAUTHORIZED);
        }
    }
}

class ResponseException extends javax.ws.rs.core.Response {
    public java_38011_CredentialValidator_A03(Response.Status status) {
        super(status);
    }
}