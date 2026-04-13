public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_34862_CredentialValidator_A01 implements CredentialValidator {
    private String correctUsername = "admin";
    private String correctPassword = "password";

    @Override
    public boolean validate(String username, String password) {
        return username.equals(correctUsername) && password.equals(correctPassword);
    }
}

public class Program {
    public static void main(String[] args) {
        CredentialValidator validator = new StoredCredentialsValidator();

        // Validate the credentials
        boolean isValid = validator.validate("admin", "password");

        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}