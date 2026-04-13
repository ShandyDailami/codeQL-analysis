public class java_08371_CredentialValidator_A07 {

    public boolean isValid(String username, String password) {
        // Assume we have a database to store usernames and passwords
        // This is a very basic implementation and does not include actual secure operations

        // The credentials are correct
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }

        // The credentials are incorrect
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // The user attempts to login with these credentials
        String username = "admin";
        String password = "password";

        // Check the user's credentials
        if (validator.isValid(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}