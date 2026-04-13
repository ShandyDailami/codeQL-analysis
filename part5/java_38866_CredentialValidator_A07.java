public class java_38866_CredentialValidator_A07 {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordStrong("ThisIsWeakPassword")); // False
        System.out.println(validator.isPasswordStrong("ThisIsVeryWeakPassword")); // False
        System.out.println(validator.isPasswordStrong("ThisIsWeakPassword1")); // True
    }
}