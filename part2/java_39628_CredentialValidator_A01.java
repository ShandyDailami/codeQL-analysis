public class java_39628_CredentialValidator_A01 {
    private static final String VALID_USERNAMES = "admin, user";
    private static final String VALID_PASSWORDS = "admin123, user123";

    public static boolean validate(String username, String password) {
        if (VALID_USERNAMES.contains(username) && VALID_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "admin123")); // true
        System.out.println(validate("user", "user123")); // true
        System.out.println(validate("admin", "wrongpassword")); // false
        System.out.println(validate("nonexistentuser", "nonexistentpassword")); // false
    }
}