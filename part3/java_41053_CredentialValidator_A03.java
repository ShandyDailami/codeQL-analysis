public class java_41053_CredentialValidator_A03 {

    // This is a simple function to check if the password is correct. 
    // In a real application, the password would likely be hashed and compared to a stored hash.
    public boolean isValidPassword(String password) {
        return password.equals("password");
    }

    // This is a simple function to check if the username is correct.
    // In a real application, the username would likely be checked against a list of allowed usernames.
    public boolean isValidUsername(String username) {
        return username.equals("admin");
    }

    // This function takes a username and password, and checks them against their predefined validators.
    // If they are valid, it returns true. If they are not, it returns false.
    public boolean validateCredentials(String username, String password) {
        if (isValidUsername(username) && isValidPassword(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }
}