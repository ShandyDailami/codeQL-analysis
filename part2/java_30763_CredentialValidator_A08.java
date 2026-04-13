public class java_30763_CredentialValidator_A08 {

    // This method checks if the given username matches a certain pattern
    // The pattern we use is checking if it contains at least one digit
    private boolean isUsernameValid(String username) {
        return username.matches(".*\\d.*");
    }

    // This method checks if the given password is a strong one
    // The pattern we use is checking if it has at least one uppercase letter, one lowercase letter, one special character, and one digit
    private boolean isPasswordValid(String password) {
        return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}");
    }

    // This method validates the credentials. It returns true if both the username and password are valid, false otherwise
    public boolean validateCredentials(String username, String password) {
        return isUsernameValid(username) && isPasswordValid(password);
    }
}