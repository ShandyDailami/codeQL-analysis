public class java_08952_CredentialValidator_A08 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isValidPassword("password123")); // true
        System.out.println(validator.isValidPassword("123password")); // false
    }

    public boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}