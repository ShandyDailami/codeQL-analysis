public class java_07909_CredentialValidator_A03 {
    private String secretPassword;

    public java_07909_CredentialValidator_A03(String secretPassword) {
        this.secretPassword = secretPassword;
    }

    public boolean isValid(String enteredPassword) {
        // This is a dummy check. It should be replaced with a more secure
        // one that checks the entered password against the secret password.
        return enteredPassword.equals(secretPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        // This is a dummy secret password. It should be replaced with actual data.
        String secretPassword = "dummyPassword";

        // Create a new CredentialValidator with the dummy password.
        CredentialValidator validator = new CredentialValidator(secretPassword);

        // Enter a password to test if it's valid.
        String enteredPassword = "invalidPassword";

        if (validator.isValid(enteredPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}