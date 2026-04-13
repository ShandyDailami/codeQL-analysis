import java.util.Base64;

public class java_14410_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_14410_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        String validUsername = "admin";
        String validPassword = "password";

        // convert credentials to byte array
        byte[] usernameBytes = this.username.getBytes();
        byte[] passwordBytes = this.password.getBytes();

        // base64 encode byte arrays
        String encodedUsername = Base64.getEncoder().encodeToString(usernameBytes);
        String encodedPassword = Base64.getEncoder().encodeToString(passwordBytes);

        // compare base64 encoded credentials with valid credentials
        return this.username.equals(validUsername) && this.password.equals(validPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if(validator.validate()) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}