public class java_01040_CredentialValidator_A03 {

    public boolean isValidUsername(String username) {
        // Check if username is not null and has at least 5 characters
        if (username != null && username.length() >= 5) {
            // Check if username contains only alphanumeric characters
            if (username.matches("^[a-zA-Z0-9]+$")) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidPassword(String password) {
        // Check if password is not null and has at least 8 characters and contains at least one number, one uppercase and one lowercase
        if (password != null && password.length() >= 8 && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$")) {
            return true;
        }
        return false;
    }

    public boolean areCredentialsValid(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.areCredentialsValid("user", "password"));  // should print true
        System.out.println(validator.areCredentialsValid("user", "12345"));  // should print false
        System.out.println(validator.areCredentialsValid("user", "password1"));  // should print false
    }
}