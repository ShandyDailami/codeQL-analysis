import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Key;

public class java_02403_CredentialValidator_A07 {

    private Key key;

    public java_02403_CredentialValidator_A07(Key key) {
        this.key = key;
    }

    public Response validateCredentials(SecurityContext securityContext) {
        String token = securityContext.getAuthentication().getCredentials();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}