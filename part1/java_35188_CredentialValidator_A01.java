import java.util.Base64;

public class java_35188_CredentialValidator_A01 {
    // No use of external libraries

    private String username;
    private String password;

    public java_35188_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a simple example of a broken access control mechanism.
        // In real-world scenarios, you would use a secure mechanism to validate the
        // credentials, such as a hashed password or a token.
        return this.username.equals("admin") && this.password.equals("password");
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}