public class java_06380_CredentialValidator_A03 {

    // This method will be used in a real-world application to validate the username and password.
    // Here we are using a simple comparison.
    public boolean validate(String username, String password) {
        // hardcoded username and password
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}