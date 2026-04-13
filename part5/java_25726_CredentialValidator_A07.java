public class java_25726_CredentialValidator_A07 implements CredentialValidator {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        return validate(credential.getUsername(), credential.getPasswordAsString());
    }

    private boolean validate(String username, String password) {
        return CORRECT_USERNAME.equals(username) && CORRECT_PASSWORD.equals(password);
    }

}