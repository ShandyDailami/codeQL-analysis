public class java_31318_CredentialValidator_A01 {
    public boolean validateCredential(String username, String password) {
        // This is a placeholder for a real-world security operation.
        // In a real-world application, passwords should be hashed and compared in a secure way.
        // This is just an example to illustrate a security-sensitive operation related to Broken Access Control (A01_BrokenAccessControl).
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        if (validator.validateCredential("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}