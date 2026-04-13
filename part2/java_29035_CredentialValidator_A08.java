public class java_29035_CredentialValidator_A08 {
    private String realPassword;

    public java_29035_CredentialValidator_A08(String realPassword) {
        this.realPassword = realPassword;
    }

    public boolean validatePassword(String attempt) {
        if (attempt.equals(realPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a new instance of CredentialValidator
        CredentialValidator validator = new CredentialValidator("correctPassword");

        // Test the validator with a password
        boolean isValid = validator.validatePassword("wrongPassword");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}