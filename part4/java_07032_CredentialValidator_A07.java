import io.jsonwebtoken.*;
import java.security.Key;
import java.util.Date;

public class java_07032_CredentialValidator_A07 implements CredentialValidator {

    private Key secretKey;

    public java_07032_CredentialValidator_A07(Key secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public boolean validate(String credential) {
        try {
            // parse the token
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(this.secretKey)
                    .build();
            Jwt jwt = parser.parse(credential);

            // validate the claims
            String issuer = jwt.getIssuer();
            String subject = jwt.getSubject();
            Date expirationTime = jwt.getExpiration();
            Date issuedAt = jwt.getIssuedAt();

            // check the issuer and subject
            if (!issuer.equals("example.com") || !subject.equals("user")) {
                return false;
            }

            // check the expiration time
            long now = new Date().getTime();
            if (new Date(expirationTime.getTime() - now).getTime() < 0) {
                return false;
            }

            // check the issued at time
            if (new Date(issuedAt.getTime() - now).getTime() < 0) {
                return false;
           
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}