public class java_28273_CredentialValidator_A07 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public CredentialResult validate(String username, String password) {
        if (password == null) {
            return CredentialResult.createFailure("Password cannot be null");
        }
        
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            return CredentialResult.createFailure("Password should be at least 8 characters and should contain at least one number, one uppercase letter, one lowercase letter and one special character");
        }
        
        return CredentialResult.createSuccess();
    }
}