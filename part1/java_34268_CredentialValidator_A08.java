import java.util.Base64;

public class java_34268_CredentialValidator_A08 {
    // Method to validate credentials
    public boolean validate(String username, String password) {
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // Base64 decode and compare with the password
            String decodedPassword = new String(Base64.getDecoder().decode(password), "UTF-8");
            return username.equals("admin") && decodedPassword.equals("password");
        } else {
            return false;
        }
    }
}