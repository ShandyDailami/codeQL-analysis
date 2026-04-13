public class java_13053_CredentialValidator_A03 {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=\\S+$).{6,}$";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = Pattern.compile(STRONG_PASSWORD_PATTERN).matcher(password);
        if (matcher.matches()) {
            return true;
        }

        matcher = Pattern.compile(WEAK_PASSWORD_PATTERN).matcher(password);
        return !matcher.matches();
    }

}