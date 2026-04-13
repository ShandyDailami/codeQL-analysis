import java.security.InvalidParameterException;
import java.util.Base64;

public class java_34267_CredentialValidator_A08 {
    private static final String SALT = "A08_IntegrityFailure";

    public static void validateCredential(String credential) {
        try {
            String decodedCredential = new String(Base64.getDecoder().decode(credential), "UTF-8");
            String[] parts = decodedCredential.split(":");
            if (parts.length != 2) {
                throw new InvalidParameterException("Credential must be in format username:password");
            }
            String username = parts[0];
            String hashedPassword = parts[1];

            // Assume we have a method to hash passwords and a method to check if the hashed password matches
            if (!checkPassword(username, hashedPassword)) {
                throw new InvalidParameterException("Invalid username or password");
            }

            System.out.println("Credential validated successfully");
        } catch (Exception e) {
            System.out.println("Error validating credential: " + e.getMessage());
        }
    }

    private static boolean checkPassword(String username, String hashedPassword) {
        // Replace with actual method to check password
        // This is a simplified example, not a complete solution
        return true;
    }

    public static void main(String[] args) {
        validateCredential(Base64.getEncoder().encodeToString("admin:$2a$10$p.Q3sWw6.2.a.t.M63p.A7.d.s.r.E.u.N.E.v.E.t.E.r.E.e.u.E.t.E.r.E.".getBytes()));
    }
}