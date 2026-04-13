public class java_29931_CredentialValidator_A01 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(Credential credential) {
        String password = credential.getPassword();
        return password.matches(PASSWORD_PATTERN);
    }

    @Override
    public String getId() {
        return "custom.validator";
    }

    @Override
    public String getDisplayName() {
        return "Custom Password Validator";
    }
}