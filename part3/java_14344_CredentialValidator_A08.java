public class java_14344_CredentialValidator_A08 {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String INTEGRITY_FAILURE_MESSAGE = "Password should contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character";

    public boolean isPasswordValid(String password) {
        if (!passwordMatchesRegex(password)) {
            System.out.println(INTEGRITY_FAILURE_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean passwordMatchesRegex(String password) {
        return password.matches(PASSWORD_REGEX);
    }
}