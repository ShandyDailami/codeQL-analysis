public class java_26271_CredentialValidator_A08 {

    // A method that validates a password
    public boolean validatePassword(String password) {
        // Here you can use any security-sensitive operations
        // For example, you can check the password against a pre-defined list of weak passwords
        List<String> weakPasswords = Arrays.asList("123456", "password", "admin", "qwerty");

        return !weakPasswords.contains(password);
    }

    // A method that validates a username
    public boolean validateUsername(String username) {
        // Here you can use any security-sensitive operations
        // For example, you can check the username against a pre-defined list of blocked usernames
        List<String> blockedUsernames = Arrays.asList("admin", "root", "guest");

        return !blockedUsernames.contains(username);
    }

    // A method that validates a Credential
    public boolean validateCredential(String username, String password) {
        // First validate the username and password
        if (!validateUsername(username) || !validatePassword(password)) {
            return false;
        }

        // If the username and password are valid, return true
        return true;
    }
}