public class java_02057_CredentialValidator_A01 {
    private String knownUsername;
    private String knownPassword;

    public java_02057_CredentialValidator_A01(String knownUsername, String knownPassword) {
        this.knownUsername = knownUsername;
        this.knownPassword = knownPassword;
    }

    public boolean validate(String username, String password) {
        return username.equals(knownUsername) && password.equals(knownPassword);
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // This should return true
        System.out.println(validator.validate("admin", "password"));

        // This should return false
        System.out.println(validator.validate("admin", "wrongPassword"));
    }
}