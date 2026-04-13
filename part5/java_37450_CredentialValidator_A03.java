public class java_37450_CredentialValidator_A03 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    private static final Pattern STRONG_PASSWORD_PATTERN_COMPLEX = Pattern.compile(STRONG_PASSWORD_PATTERN);

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = new String(credential.getPassword());
        Matcher matcher = STRONG_PASSWORD_PATTERN_COMPLEX.matcher(password);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}