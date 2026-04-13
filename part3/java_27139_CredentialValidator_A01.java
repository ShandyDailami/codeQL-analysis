public class java_27139_CredentialValidator_A01 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String password = credential.getPasswordAsString();
        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if (!matcher.matches()) {
            throw new InvalidCredentialException("Password does not meet the required complexity requirements (must contain at least one number, one uppercase letter, one lowercase letter, one special character, and be at least 8 characters long).");
        }

        return true;
    }
}