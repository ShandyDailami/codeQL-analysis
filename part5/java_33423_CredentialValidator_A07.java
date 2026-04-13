public class java_33423_CredentialValidator_A07 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String password = credential.getPasswordAsString();
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            throw new InvalidCredentialException("Password is not strong enough");
        }
        return true;
    }

}