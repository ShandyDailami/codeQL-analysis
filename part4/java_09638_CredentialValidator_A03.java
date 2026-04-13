public class java_09638_CredentialValidator_A03 {

    // This method checks if the username contains illegal characters.
    // If it does, it returns false. Otherwise, it returns true.
    public boolean validateUsername(String username) {
        if (username.matches(".*[<>\\\"\\'].*")) {
            return false;
        }

        return true;
    }

    // This method checks if the password contains illegal characters.
    // If it does, it returns false. Otherwise, it returns true.
    public boolean validatePassword(String password) {
        if (password.matches(".*[`~@#$%^&*()_=-\\\\+{}\[\]|\\\\:;'<,>]*.")) {
            return false;
        }

        return true;
    }

    // This method validates the email address.
    // It checks if the email contains illegal characters and if the email has the wrong format.
    public boolean validateEmail(String email) {
        if (email.matches(".*@.*..*") && !email.matches(".*@.+\\..+")) {
            return false;
        }

        return true;
    }

    // This method validates the phone number.
    // It checks if the phone number contains illegal characters and if the phone number has the wrong format.
    public boolean validatePhone(String phone) {
        if (phone.matches(".*[^0-9]*")) {
            return false;
        }

        return true;
    }
}