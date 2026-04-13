public class java_37381_CredentialValidator_A03 {

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        
        // In this example, we are just checking if the username is 'admin' and the password is 'password'. 
        // In a real application, you would need to compare this to a hashed version of the password in your database.
        return username.equalsIgnoreCase("admin") && password.equals("password");
    }
}