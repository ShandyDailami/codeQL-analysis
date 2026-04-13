public class java_37406_CredentialValidator_A08 {

    // This is the main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.start();
    }

    // Include the below method in the CredentialValidator class
    public void start() {
        // Create a username and password
        String username = "admin";
        String password = "password";

        // Invoke the method and pass the username and password
        if(validateCredentials(username, password)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    // This is the method for validating the credentials
    public boolean validateCredentials(String username, String password) {
        // For the sake of this example, we'll check if the username is "admin"
        // and the password is "password". In a real-world scenario, you'd
        // want to use hashing and encryption for security purposes.
        if(username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}