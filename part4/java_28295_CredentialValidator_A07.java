import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class java_28295_CredentialValidator_A07 {

    public static void main(String[] args) {
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MTIyfQ.SflKW5hsbGciOiJFBS53bzEyY3RfcmQWN2aWVzIiwiaXNzIjoidXNlciJ9.xxxxx";
        validateToken(token);
    }

    public static void validateToken(String token) {
        if (token != null) {
            JwtParser parser = Jwts.parser().setSigningKey("secret");

            Jws<Claims> claims = parser.parseClaimsJws(token.split(" ")[1]);

            Claims body = claims.getBody();

            System.out.println("Issued at: " + body.getIssuedAt());
            System.out.println("Expiration time: " + body.getExpiration().getTime());
            System.out.println("Subject: " + body.getSubject());

            if (body.getIssuer().equals("user")) {
                System.out.println("Issuer is valid");
            } else {
                System.out.println("Issuer is not valid");
            }
        }
    }
}