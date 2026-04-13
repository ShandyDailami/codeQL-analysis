public class java_12221_CredentialValidator_A07 {

    // Method to validate the login
    public boolean validateLogin(String username, String password) {

        // In a real-world application, you would typically connect to a database
        // to check if the username and password match something in the database

        // This example is very basic, and only checks if the username and password are 'admin'
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}