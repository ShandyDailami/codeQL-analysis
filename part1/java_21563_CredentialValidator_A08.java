public class java_21563_CredentialValidator_A08 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    public static boolean validate(String inputUsername, String inputPassword) {
        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(validate("test", "password")); // true
        System.out.println(validate("wrong", "password")); // false
        System.out.println(validate("test", "wrong")); // false
        System.out.println(validate("wrong", "wrong")); // false
    }
}