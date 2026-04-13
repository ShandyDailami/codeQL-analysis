public class java_24979_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password"));
        System.out.println(validateCredentials("user", "wrongpassword"));
    }

    public static boolean validateCredentials(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}