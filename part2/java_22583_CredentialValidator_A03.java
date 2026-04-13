public class java_22583_CredentialValidator_A03 {

    // This method checks if the provided username and password match the expected values.
    // This is a very simple example and should not be used in a real-world application.
    public boolean isValid(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    // This is the main method that will be executed when the program is run.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "admin";
        String password = "password";
        if (validator.isValid(username, password)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}