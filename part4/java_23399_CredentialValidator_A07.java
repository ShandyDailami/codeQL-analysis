import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ws.rs.core.MultipartEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Optional;

public class java_23399_CredentialValidator_A07 {

    // This is a static secret key, not recommended for production use
    private static final String SECRET = "secret";

    public static Optional<Response> validate(SecurityContext securityContext) {
        // Get the token from the request
        String token = securityContext.getAuthentication().getCredentials();

        // Verify the token
        if (token != null && !token.isEmpty()) {
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token)
                        .getBody();

                // Check if the token is expired
                if (claims.getExpiration().before(new Date())) {
                    return Optional.of(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            } catch (Exception e) {
                return Optional.of(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        } else {
            return Optional.of(Response.status(Response.Status.UNAUTHORIZED).build());
        }

        return Optional.empty();
    }
}