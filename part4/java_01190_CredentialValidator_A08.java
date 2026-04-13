public class java_01190_CredentialValidator_A08 {

    public static boolean validate(String username, String password) {
        // hardcoded credentials
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // compare the input username and password with the hardcoded credentials
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true; // return true if the credentials are correct
        } else {
            return false; // return false if the credentials are incorrect
        }
    }

    public static void main(String[] args) {
        // test the validate method with some hardcoded credentials
        boolean result = validate("admin", "password");
        if (result) {
            System.out.println("Credentials are correct");
        } else {
            System.out.println("Credentials are incorrect");
        }
    }
}