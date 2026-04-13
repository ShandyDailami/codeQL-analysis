public class java_41256_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "StrongPassword";

    public boolean isValidUsername(String username) {
        // Check if username is 'validUser'
        if (username.equals(VALID_USERNAME)) {
            System.out.println("Username is valid.");
            return true;
        } else {
            System.out.println("Username is not valid.");
            return false;
        }
    }

    public boolean isStrongPassword(String password) {
        // Check if password is 'StrongPassword'
        if (password.equals(VALID_PASSWORD)) {
            System.out.println("Password is strong.");
            return true;
        } else {
            System.out.println("Password is not strong enough.");
            return false;
        }
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isStrongPassword(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials(VALID_USERNAME, VALID_PASSWORD);
    }
}