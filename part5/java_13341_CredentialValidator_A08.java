public class java_13341_CredentialValidator_A08 {
    private String correctUsername = "admin";
    private String correctPassword = "password";

    public boolean isValidCredentials(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidCredentials("admin", "password")); // Outputs: true
        System.out.println(validator.isValidCredentials("wrong", "password")); // Outputs: false
    }
}