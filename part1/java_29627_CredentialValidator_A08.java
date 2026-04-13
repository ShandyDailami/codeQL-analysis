public class java_29627_CredentialValidator_A08 {

    // hardcoded set of valid credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // check if the provided username and password match the hardcoded set
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // testing the validate method
        boolean isValid = validate("admin", "password");
        System.out.println("Is valid: " + isValid);
   
        // testing the validate method with incorrect credentials
        isValid = validate("admin", "incorrectpassword");
        System.out.println("Is valid: " + isValid);
    }
}