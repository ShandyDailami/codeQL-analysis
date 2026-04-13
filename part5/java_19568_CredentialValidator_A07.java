public class java_19568_CredentialValidator_A07 {

    // Simulate database
    private static String dbUsername = "admin";
    private static String dbPassword = "password";

    // Credentials provided by the user
    private String providedUsername;
    private String providedPassword;

    public java_19568_CredentialValidator_A07(String providedUsername, String providedPassword) {
        this.providedUsername = providedUsername;
        this.providedPassword = providedPassword;
    }

    public boolean validate() {
        // In a real-world scenario, you'd use a secure way to hash and compare passwords
        // (such as using a password hashing algorithm like bcrypt)
        // This is a simplification for the sake of the example
        return providedUsername.equals(dbUsername) && providedPassword.equals(dbPassword);
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}