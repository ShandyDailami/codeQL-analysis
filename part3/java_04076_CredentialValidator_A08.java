public class java_04076_CredentialValidator_A08 {

    // Define a method for checking if the user name is valid
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        
        if (username.length() < 4 || username.length() > 20) {
            return false;
        }
        
        for (char c : username.toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        
        return true;
    }

    // Define a method for checking if the password is valid
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        
        if (password.length() < 8 || password.length() > 64) {
            return false;
        }
        
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        
        return true;
    }

    // Define a method for checking if the confirmation password is valid
    public boolean isValidConfirmationPassword(String password, String confirmationPassword) {
        if (!password.equals(confirmationPassword)) {
            return false;
        }
        
        if (!isValidPassword(password)) {
            return false;
        }
        
        return true;
    }

    // Define a method for checking if the email is valid
    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        return email.matches(emailPattern);
    }
}