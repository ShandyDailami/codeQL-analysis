import java.util.Base64;

public class java_01245_CredentialValidator_A03 {

    private final String username;
    private final String password;

    public java_01245_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // We assume the input credentials are already Base64 encoded
        // In a real-world scenario, you should not trust the input data
        // You should handle exceptions, and possibly use a more secure method
        // of checking the credentials against a database or a secure storage.
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // For the sake of simplicity, we're checking if the password matches the username
        return this.username.equals(decodedPassword);
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "dXBkYXBsZWRfc2VjcmV0LmNvbQ=="; // "admin" in Base64

        CredentialValidator validator = new CredentialValidator(username, password);
        System.out.println("Is the validator valid? " + validator.isValid());
    }
}