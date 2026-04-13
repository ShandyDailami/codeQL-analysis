public class java_39427_CredentialValidator_A03 {
    // private variables for username and password
    private String username;
    private String password;

    // constructor to initialize username and password
    public java_39427_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // method to validate username and password
    public boolean validate() {
        // for simplicity, we'll just check if the username and password are not null
        if (username == null || password == null) {
            return false;
        }

        // in a real application, you'd likely want to use a hashing algorithm
        // to ensure that the passwords are securely stored, and to verify the password
        // against a stored hash
        // for simplicity, let's just check if the username is "admin" and the password is "password"
        return username.equals("admin") && password.equals("password");
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        // Creating CredentialValidator with valid credentials
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the credentials
        boolean isValid = validator.validate();

        // Print the result
        System.out.println("Is Valid: " + isValid);
    }
}