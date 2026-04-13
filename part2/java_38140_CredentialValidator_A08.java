public class java_38140_CredentialValidator_A08 {

    // Function to check if the username matches the password
    public boolean validate(String username, String password) {
        // In a real-world scenario, the password should be hashed and the user should be checked against a pre-hashed
        // password in the database (a security violation). This is just a placeholder for demonstration purposes.
        if (username.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // A simple check for a null or empty username
    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("Invalid username!");
            return false;
        }
        return true;
    }

    // A simple check for a null or empty password
    public boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            System.out.println("Invalid password!");
            return false;
        }
        return true;
    }

    // The main method where the checks are performed
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.isValidUsername("");
        validator.isValidPassword("");
        validator.validate("test", "test");
    }
}