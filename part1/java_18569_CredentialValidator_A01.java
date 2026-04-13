public class java_18569_CredentialValidator_A01 {
    // Hardcoded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        String user = "user";
        String password = "password";
        if (validate(user, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}