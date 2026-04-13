public class java_10508_CredentialValidator_A01 {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("test", "test")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    public boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}