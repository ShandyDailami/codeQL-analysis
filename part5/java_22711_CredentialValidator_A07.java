public class java_22711_CredentialValidator_A07 implements CredentialValidator {
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public boolean validate(CredentialContext context) throws CredentialValidationException {
        String password = context.getPassword();

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new CredentialValidationException("Invalid password. Password should contain at least one digit, one uppercase and lowercase letter, one special character and should be at least 8 characters long");
        }

        return true;
    }
}