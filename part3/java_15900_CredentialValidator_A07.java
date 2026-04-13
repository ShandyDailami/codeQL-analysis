public class java_15900_CredentialValidator_A07 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean isValid(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

    public static void main(String[] args) {
        MinimalistCredentialValidator validator = new MinimalistCredentialValidator();
        
        // Test the validator
        boolean isValid = validator.isValid("admin", "password");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}