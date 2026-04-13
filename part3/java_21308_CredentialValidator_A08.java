public class java_21308_CredentialValidator_A08 {
    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";

    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        String username = "testUser";
        String password = "wrongPassword";

        if (validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}