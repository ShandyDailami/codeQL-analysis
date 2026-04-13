import java.util.Base64;

public class java_18480_CredentialValidator_A01 {

    public boolean validateCredentials(String username, String password) {
        try {
            String expectedUsername = "admin";
            String expectedPassword = "password";

            String providedUsername = new String(Base64.getDecoder().decode(username));
            String providedPassword = new String(Base64.getDecoder().decode(password));

            if (providedUsername.equals(expectedUsername) && providedPassword.equals(expectedPassword)) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}