public class java_01165_CredentialValidator_A01 implements CredentialValidator {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern passwordPattern = Pattern.compile(STRONG_PASSWORD_PATTERN);

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = new String(credential.getCredentials());
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}