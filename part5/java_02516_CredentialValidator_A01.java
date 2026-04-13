public class java_02516_CredentialValidator_A01 {

    public boolean validateCredentials(String username, String password) {
        // This is a very simple validation. In a real-world application, you'd want to hash the password and compare the hashed version to the database.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.validateCredentials("admin", "wrongpassword");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            validator.validateCredentials("wrongusername", "password");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            validator.validateCredentials("admin", "password");
            System.out.println("Credentials are valid");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}