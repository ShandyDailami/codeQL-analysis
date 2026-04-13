public class java_11465_CredentialValidator_A01 {

    public boolean isValidUsername(String username) {
        // Assume username is not null and not empty
        return username != null && !username.isEmpty();
    }

    public boolean isValidPassword(String password) {
        // Assume password is not null and not empty
        return password != null && !password.isEmpty();
    }

    public boolean isValid(String username, String password) {
        // Assume both username and password are not null and not empty
        return isValidUsername(username) && isValidPassword(password);
    }

    public String validate(String username, String password) {
        // Assume both username and password are not null and not empty
        if (!isValid(username, password)) {
            return "Invalid username or password";
        }

        // If everything is valid, return a success message
        return "Credentials validated successfully";
    }
}