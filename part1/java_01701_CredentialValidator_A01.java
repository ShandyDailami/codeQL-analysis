import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.security.Key;
import java.util.Base64;
import java.util.Optional;

@Provider
public class java_01701_CredentialValidator_A01 {

    private static final Key signingKey =
            new org.json.JSONObject(new String(Base64.getDecoder().decode("your_256_bit_secret"))).getJSONObject("keys").getJSONObject("signing").toString().getBytes("UTF-8");

    public Response validateCredentials(String username, String password) {
        if (BCrypt.checkpw(password, Optional.ofNullable(username).map(this::getPasswordHash).orElse("")) {
            String token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512, signingKey)
                    .compact();

            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String getPasswordHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}