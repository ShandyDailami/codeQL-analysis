public class java_38678_CredentialValidator_A07 {
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return password.matches(PASSWORD_REGEX);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "ThisIsAStrongPassword1";
        boolean isValid = validator.validatePassword(password);
        System.out.println("Is password valid? " + isValid);
    }
}