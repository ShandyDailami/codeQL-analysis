public class java_21319_CredentialValidator_A03 {

    // hard-coded credentials
    private static String username = "user";
    private static String password = "pass";

    public static void main(String[] args) {
        // test the validator
        String user = "testUser";
        String pass = "testPass";
        validate(user, pass);
    }

    public static void validate(String user, String pass) {
        // check if the provided credentials match the hard-coded values
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}