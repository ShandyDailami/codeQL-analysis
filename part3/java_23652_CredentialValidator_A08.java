public class java_23652_CredentialValidator_A08 {

    // Static password to be used for comparison
    private static String predefinedPassword = "123456";

    // Method to validate the password
    public static boolean validate(String password) {
        return password.equals(predefinedPassword);
    }

    public static void main(String[] args) {
        System.out.println(validate("123456")); // Should print true
        System.out.println(validate("123457")); // Should print false
    }
}