public class java_37923_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validatePassword("Password@123"));
    }
}