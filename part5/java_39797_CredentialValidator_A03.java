public class java_39797_CredentialValidator_A03 {

    public static boolean validate(String username) {
        // Check if the username is alphanumeric
        if (username.matches("^[a-zA-Z0-9]+$")) {
            System.out.println("Username is valid.");
            return true;
        } else {
            System.out.println("Username is not valid.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        validate("test"); // valid username
        validate("test123"); // invalid username
    }
}