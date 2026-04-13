public class java_25789_CredentialValidator_A08 {

    private String hardCodedUsername = "admin";
    private String hardCodedPassword = "password";

    public boolean isValid(String username, String password) {
        // Check if the provided username and password match the hardcoded ones
        if (username.equals(hardCodedUsername) && password.equals(hardCodedPassword)) {
            System.out.println("Valid credentials!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }
}