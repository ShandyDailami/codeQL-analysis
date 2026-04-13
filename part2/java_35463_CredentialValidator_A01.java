import io.jsonwebtoken.*;

public class java_35463_CredentialValidator_A01 {
    public static boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature - " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token - " + e.getMessage());
       
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token - " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty - " + e.getMessage());
        }
        return false;
    }
}