public class java_02583_CredentialValidator_A08 {
    private String hardcodedPassword = "strongPassword"; // Hardcoded password

    public boolean validate(String userPassword) {
        return userPassword.equals(hardcodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("wrongPassword");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}