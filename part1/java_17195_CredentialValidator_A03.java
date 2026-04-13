public class java_17195_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        return !(username.isEmpty() || password.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(validate("", "")); // Should print false
        System.out.println(validate("user", "")); // Should print false
        System.out.println(validate("", "password")); // Should print false
        System.out.println(validate("user", "password")); // Should print true
    }
}