public class java_22675_CredentialValidator_A01 {

    public static void main(String[] args) {
        Credential credential = new Credential();
        credential.username = "admin";
        credential.password = "password";
        
        if (isValid(credential)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean isValid(Credential credential) {
        // Implementing a dummy security check here for the sake of this example.
        // In a real application, this would be a more complex process involving hashing and salting passwords,
        // and possibly integrating with a database to validate users.
        
        // This is a simplistic example of a broken access control.
        // In a real application, the password would not be hashed or stored in plain text,
        // and instead would be hashed and stored using a password hashing function.
        // Also, a real application would not allow for more than one user to exist with the same username,
        // and would not allow for more than one access level to be granted to a user.
        // In this example, the username and password are hard-coded in the program.
        
        if (credential.username.equals("admin") && credential.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static class Credential {
        String username;
        String password;
    }
}