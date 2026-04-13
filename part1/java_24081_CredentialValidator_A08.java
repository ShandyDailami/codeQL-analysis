import java.util.Base64;

public class java_24081_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_24081_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // In real world, this method would connect to a database and check the provided password against the hashed password.
        // For the purposes of this example, we're just checking if the provided password matches a static password.
        return this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");
        System.out.println("Is valid: " + validator.validate());
   
        // In a real-world application, you would not store passwords in plain text.
        // Instead, you would store hashes of the passwords, and then compare the hashes.
    }
}