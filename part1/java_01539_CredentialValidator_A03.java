import java.security.InvalidParameterException;

public class java_01539_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null.");
        }
        
        // Validate username and password here. For simplicity, we just check if they're empty
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        // Validate the password length here. This is just a simple example,
        // in a real application you'd want to use a more complex validation logic.
        if (password.length() < 8) {
            return false;
        }
        
        // Validate if the password contains a digit or a special character.
        // This is also a simple example, in a real application you'd want to use a more complex validation logic.
        if (!hasDigit(password) || !hasSpecialCharacter(password)) {
            return false;
        }
        
        // If all validation checks pass, return true
        return true;
    }
    
    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                return true;
            }
        }
        return false;
    }
}