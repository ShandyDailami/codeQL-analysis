import java.util.Base64;

public class java_22856_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public static void main(String[] args) {
        // Test username and password
        CredentialValidator validator = new CredentialValidator("user", "password");
        System.out.println("Is valid? " + validator.isValid());

        // Test with incorrect password
        CredentialValidator invalidator = new CredentialValidator("user", "wrongpassword");
        System.out.println("Is valid? " + invalidator.isValid());
   
        // Test with incorrect username
        CredentialValidator invalidUser = new CredentialValidator("wronguser", "password");
        System.out.println("Is valid? " + invalidUser.isValid());
    }

    private String username;
    private String password;

    public java_22856_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return this.username.equals(VALID_USERNAME) && this.password.equals(VALID_PASSWORD);
    }
}