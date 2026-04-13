// A simple credential validator example
public class java_24777_CredentialValidator_A07 {
    // Validate login attempt
    public boolean validate(String username, String password) {
        // Assume there is a method to check credentials
        // Replace this with your own method or service
        if (isValid(username, password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // Simulate a method to check credentials
    private boolean isValid(String username, String password) {
        // Here you can simulate the check for failed attempts
        // In real world, you would use a database to store and compare hashes of passwords
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password"); // should print "Login successful!"
        validator.validate("wrong_username", "wrong_password"); // should print "Login failed!"
    }
}