public class java_28333_CredentialValidator_A01 {

    // The validate method. It takes in a username and a password
    public boolean validate(String username, String password) {
        // Check if the username is "admin"
        if ("admin".equals(username)) {
            // Check if the password is "admin"
            if ("admin".equals(password)) {
                // If both are correct, return true
                return true;
            } else {
                // Otherwise, return false
                return false;
            }
        } else {
            // If the username is not "admin", return false
            return false;
        }
    }

}