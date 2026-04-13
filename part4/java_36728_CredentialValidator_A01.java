public class java_36728_CredentialValidator_A01 {
    private String username;
    private String password;

    // Constructor
    public java_36728_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check if the credential is valid
    public boolean isCredentialValid() {
        // You'll want to use secure methods to hash and compare the passwords here.
        // This is a simplified example where we compare the password directly.
        // In a real application, you should not store the passwords in plain text.
        return this.username.equals("admin") && this.password.equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.isCredentialValid());
    }
}