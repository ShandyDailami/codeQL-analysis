// Credential class java_29897_CredentialValidator_A07 class Credential {
    private String username;
    private String password;

    public CredentialValidator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// CredentialValidator class
public class CredentialValidator {
    private Credential storedCredential;

    public CredentialValidator() {
        storedCredential = new Credential("admin", "password"); // Initialize with a known user
    }

    public boolean validate(String username, String password) {
        return (storedCredential.getUsername().equals(username) && storedCredential.getPassword().equals(password));
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}