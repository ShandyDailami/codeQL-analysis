import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class java_00559_CredentialValidator_A03 {

    // Secret key for JWT
    private static final String SECRET = "my_secret_key";

    // Algorithm used to sign the JWT
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public static void main(String[] args) {
        String token = createJWT("user1");
        validateJWT(token);
    }

    public static String createJWT(String subject) {
        JwtBuilder builder = Jwts.builder();
        // Set expiration time
        builder.setExpiration(getExpirationDate(1000));
        // Set subject
        builder.setSubject(subject);
        // Add claims
        builder.addClaims(getClaims(subject));
        // Sign JWT
        return builder.signWith(algorithm).compact();
    }

    private static Claims getClaims(String subject) {
        return Jwts.claims().persistent(subject);
    }

    private static String getExpirationDate(int hours) {
        long expirationTimeInMilliseconds = hours * 60 * 1000;
        return new Date(System.currentTimeMillis() + expirationTimeInMilliseconds).toString();
    }

    public static void validateJWT(String token) {
        JwtParser parser = Jwts.parserBuilder(token, algorithm).build();
        try {
            // Parse and print the token
            parser.parseClaimsJws(token);
            System.out.println("Valid JWT Token");
        } catch (JWTVerificationException exception) {
            System.out.println("Invalid JWT Token");
        }
    }
}