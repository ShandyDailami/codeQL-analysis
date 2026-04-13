public class java_18000_CredentialValidator_A03 {

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";

    public static boolean validate(String user, String pass) {
        if (user == null || pass == null) {
            return false;
        }
        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(validate("testUser", "testPassword")); // Outputs: true
        System.out.println(validate("wrongUser", "wrongPassword")); // Outputs: false
    }
}