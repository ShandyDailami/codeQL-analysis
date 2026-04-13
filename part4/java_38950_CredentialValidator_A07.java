import java.security.NoSuchAlgorithmException;
import java.security.PasswordAuthentication;
import java.security.Security;

public class java_38950_CredentialValidator_A07 {

    public static void main(String[] args) {
        // Create a custom security manager
        Security.addProvider(new CustomProvider());

        // Create a password authentication object
        PasswordAuthentication authentication = new PasswordAuthentication("test", "test".toCharArray());

        // Validate the authentication object
        CredentialValidator validator = new CredentialValidator();
        validator.validate(authentication);
    }

    public void validate(PasswordAuthentication authentication) {
        String password = authentication.getPassword().toString();
        boolean isValid = isPasswordStrong(password);

        if (!isValid) {
            System.out.println("Invalid password");
        } else {
            System.out.println("Valid password");
        }
    }

    private boolean isPasswordStrong(String password) {
        boolean digitFound = false, upperCaseFound = false, lowerCaseFound = false, specialCharsFound = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitFound = true;
            } else if (Character.isUpperCase(c)) {
                upperCaseFound = true;
            } else if (Character.isLowerCase(c)) {
                lowerCaseFound = true;
            } else if (!isValidSpecialCharacter(c)) {
                specialCharsFound = true;
            }

            if (!digitFound || !upperCaseFound || !lowerCaseFound || !specialCharsFound) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidSpecialCharacter(char c) {
        return !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }

    // Custom provider
    private static class CustomProvider extends Security.Provider {
        private static final long serialVersionUID = 0L;

        @Override
        public String choosePassword(char[] c) {
            return "test";
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("test", "test".toCharArray());
        }
    }
}