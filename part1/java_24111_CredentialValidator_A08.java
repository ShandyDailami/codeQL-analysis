public class java_24111_CredentialValidator_A08 {
    private String hardcodedPassword;

    public java_24111_CredentialValidator_A08(String hardcodedPassword) {
        this.hardcodedPassword = hardcodedPassword;
    }

    public boolean validate(String inputPassword) {
        // Remove the following line if you want to print the passwords directly.
        System.out.println("Input password: " + inputPassword);
        System.out.println("Hardcoded password: " + hardcodedPassword);

        // Equality check.
        return inputPassword.equals(hardcodedPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        // Testing the credential validator.
        CredentialValidator validator = new CredentialValidator("password123");

        // Input a password that matches the hardcoded password.
        if (validator.validate("password123")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}