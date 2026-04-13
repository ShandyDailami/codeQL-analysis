import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class java_10760_CredentialValidator_A01 {

    private static final String SECRET = "ThisIsASecret";

    public static void main(String[] args) {
        String token = createToken("username", "password");
        System.out.println("Generated token: " + token);

        Map<String, Object> result = validateToken(token);
        if (result != null) {
            System.out.println("Validation failed: " + result.toString());
        } else {
            System.out.println("Validation succeeded!");
        }
    }

    private static String createToken(String username, String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("password", password);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .compact();
    }

    private static Map<String, Object> validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return new HashMap<>();
        } catch (Exception e) {
            return e.getStackTrace().toString();
        }
    }
}