public class java_11672_CredentialValidator_A01 implements CredentialValidator {
    @Override
    public boolean validate(Credential credential) {
        String password = credential.getPassword();
        
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }
        
        // Check if password contains at least one uppercase letter
        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }
        
        // Check if password contains at least one lowercase letter
        if (!Character.isLowerCase(password.charAt(0))) {
            return false;
        }
        
        // Check if password contains at least one number
        if (!Character.isDigit(password.charAt(0))) {
            return false;
        }
        
        // If all checks pass, password is strong enough
        return true;
    }
}