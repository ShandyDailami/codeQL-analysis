public class java_25781_CredentialValidator_A01 {

    private String correctUsername = "admin";
    private String correctPassword = "password";

    public boolean validate(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("admin", "password");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}