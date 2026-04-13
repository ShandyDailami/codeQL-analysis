import java.util.Base64;

public class java_36693_CredentialValidator_A03 {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public boolean validateCredentials(String username, String password) {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String adminCredentials = Base64.getEncoder().encodeToString("admin:password".getBytes());
        boolean isValid = validator.validateCredentials("admin", "password");
        System.out.println("Is valid? " + isValid);
    }
}