import java.security.Principal;

public class java_11109_CredentialValidator_A07 {
    public boolean validate(Principal principal) {
        String username = principal.getName();
        String password = principal.getPassword();

        // Here you should use your own logic to check if the username and password are valid
        // For simplicity, let's assume they are valid
        if (username != null && username.equals("valid_username") && password != null && password.equals("valid_password")) {
            return true;
        }

        return false;
    }
}