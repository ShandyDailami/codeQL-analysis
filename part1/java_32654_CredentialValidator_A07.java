public class java_32654_CredentialValidator_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        if (validate("user", "password")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    public static boolean validate(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}