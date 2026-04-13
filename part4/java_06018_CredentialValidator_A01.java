public class java_06018_CredentialValidator_A01 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String password = credential.getPasswordAsString();
        if (password == null) {
            throw new CredentialException("Invalid password");
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Password does not match required pattern");
        }

        return true;
    }
}