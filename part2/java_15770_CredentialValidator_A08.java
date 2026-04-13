public class java_15770_CredentialValidator_A08 {

    // Hardcoded password pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        // Using Pattern and Matcher classes from java.util.regex package
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        // Checking if password matches the pattern
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}