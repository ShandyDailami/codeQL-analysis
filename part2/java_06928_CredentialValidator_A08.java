public class java_06928_CredentialValidator_A08 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("[A-Za-z0-9]{4,16}");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("[A-Za-z0-9]{8,20}");

    public boolean isValidUsername(String username) {
        return username != null && VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}