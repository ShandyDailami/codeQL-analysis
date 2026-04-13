public class java_16582_CredentialValidator_A01 {
    private static final int PASSWORD_MINIMUM_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < PASSWORD_MINIMUM_LENGTH) {
            return false;
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String password = "thisIsAWeakPassword";
        if (validator.isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}