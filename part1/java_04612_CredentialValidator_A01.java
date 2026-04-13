public class java_04612_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String inputUsername, String inputPassword) {
        if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
            return true; // Validation successful
        } else {
            return false; // Validation failed
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password")); // Validates with correct credentials
        System.out.println(validate("wrongUser", "wrongPassword")); // Validates with incorrect credentials
    }
}