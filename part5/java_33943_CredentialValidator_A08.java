public class java_33943_CredentialValidator_A08 {

    // The method checks if a given password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        return password.length() >= 8;
    }

    // The method checks if a given password contains at least one upper case letter
    public boolean containsUpperCaseLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    // The method checks if a given password contains at least one lower case letter
    public boolean containsLowerCaseLetter(String password) {
        return password.matches(".*[a-z].*");
    }

    // The method checks if a given password contains at least one digit
    public boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    // The method checks if a given password contains at least one special character
    public boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\".<>\\?\\|`\\\\].*");
    }

    // The method validates the password
    public boolean validatePassword(String password) {
        if (isPasswordStrongEnough(password) && containsUpperCaseLetter(password) && 
            containsLowerCaseLetter(password) && containsDigit(password) && containsSpecialCharacter(password)) {
            return true;
        } else {
            return false;
        }
    }
}