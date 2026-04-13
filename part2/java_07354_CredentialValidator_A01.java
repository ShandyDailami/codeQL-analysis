public class java_07354_CredentialValidator_A01 {

    // This is a simple password check. In a real application, you would typically store hashed passwords and compare them.
    public boolean isPasswordValid(String password) {
        // The password is a simple check. In a real application, you would probably want to add more complex rules.
        if (password == null) {
            return false;
        }
        return password.length() > 7;
    }

    // This is a simple username check. In a real application, you would typically store usernames and compare them.
    public boolean isUsernameValid(String username) {
        if (username == null) {
            return false;
        }
        return username.length() > 0;
    }

    // A simple function to validate a username and password. In a real application, you would typically use a service or manager to handle these checks.
    public void validate(String username, String password) {
        if (!isUsernameValid(username)) {
            System.out.println("Invalid username");
            return;
        }
        if (!isPasswordValid(password)) {
            System.out.println("Invalid password");
            return;
        }
        System.out.println("Credentials valid");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("", "password");  // Invalid username, should print "Invalid username"
        validator.validate("username", "");  // Invalid password, should print "Invalid password"
        validator.validate("username", "password");  // Credentials valid, should print "Credentials valid"
    }
}