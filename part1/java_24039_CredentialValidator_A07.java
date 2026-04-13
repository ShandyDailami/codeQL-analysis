import io.jsonwebtoken.*;

public class java_24039_CredentialValidator_A07 {

    private static final String SECRET = "mySecret";

    public static boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parse(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        if (isValid(token)) {
            System.out.println("Valid token");
        } else {
            System.out.println("Invalid token");
        }
    }
}