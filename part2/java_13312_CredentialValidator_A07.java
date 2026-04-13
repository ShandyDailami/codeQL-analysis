public class java_13312_CredentialValidator_A07 {
    // hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) {
        // test the validator
        boolean isValid = validate("admin", "password");
        System.out.println("Is valid? " + isValid);

        isValid = validate("wrongUsername", "wrongPassword");
        System.out.println("Is valid? " + isValid);
   
        isValid = validate("admin", "wrongPassword");
        System.out.println("Is valid? " + isValid);
    }
}