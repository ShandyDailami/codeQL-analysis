// Remove the comment before running the code

// Credential class java_10916_CredentialValidator_A01 class Credential {
    public boolean validatePassword(String password) {
        // Assume the password is the correct one for this example
        return password.equals("correct_password");
    }
}

// CredentialValidator class
public class CredentialValidator {
    private Credential credential;

    public CredentialValidator(Credential credential) {
        this.credential = credential;
    }

    public boolean validate(String password) {
        // Assume the user is logged in
        return credential.validatePassword(password);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential();
        CredentialValidator validator = new CredentialValidator(credential);

        // Validate the user
        boolean isValid = validator.validate("wrong_password");
        System.out.println("Is the password valid? " + isValid);
    }
}