//import necessary libraries
import java.security.Credential;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_21738_CredentialValidator_A08 {

    // Method to validate if credential is valid
    public boolean isValidCredential(Credential credential) throws NoSuchAlgorithmException, InvalidParameterException {
        
        // Check if credential is null
        if(credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }
        
        // Check if password length is more than 6 characters
        if(credential.getPassword().length() <= 6) {
            throw new InvalidParameterException("Password length must be more than 6 characters");
        }
        
        // Check if password contains uppercase letter
        if(!hasUpperCase(credential.getPassword())) {
            throw new InvalidParameterException("Password must contain at least one uppercase letter");
        }
        
        // Check if password contains number
        if(!hasDigit(credential.getPassword())) {
            throw new InvalidParameterException("Password must contain at least one number");
        }
        
        // Check if password contains special character
        if(!hasSpecialChar(credential.getPassword())) {
            throw new InvalidParameterException("Password must contain at least one special character");
        }
        
        // If all checks pass, credential is valid
        return true;
    }

    // Method to check if password contains uppercase letter
    private boolean hasUpperCase(String password) {
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    // Method to check if password contains number
    private boolean hasDigit(String password) {
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c))
                return true;
        }
        return false;
    }

    // Method to check if password contains special character
    private boolean hasSpecialChar(String password) {
        for(char c : password.toCharArray()) {
            if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
                return true;
        }
        return false;
    }
}