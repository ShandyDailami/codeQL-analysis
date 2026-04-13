public class java_41073_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // You can call the validate method with different username and password
        // The validate method will return true if the credentials match, otherwise it will return false.
        System.out.println(validate("admin", "password")); // True
        System.out.println(validate("wrongUser", "password")); // False
        System.out.println(validate("admin", "wrongPassword")); // False
        System.out.println(validate("wrongUser", "wrongPassword")); // False
    }
}