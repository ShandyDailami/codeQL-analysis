public class java_25413_CredentialValidator_A07 {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";
    private static boolean isValid = false;

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.authenticate("admin", "password");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public void authenticate(String username, String password) {
        validate(username, password);
    }

    private void validate(String username, String password) {
        if (isValidCredentials(username, password)) {
            System.out.println("Valid credentials!");
            isValid = true;
        } else {
            System.out.println("Invalid credentials!");
            isValid = false;
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }
}