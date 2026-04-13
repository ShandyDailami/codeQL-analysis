public class java_09749_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "ThisIsMyStrongPassword";
        System.out.println(validator.isPasswordStrong(password));
    }
}