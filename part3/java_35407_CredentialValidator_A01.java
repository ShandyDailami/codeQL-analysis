public class java_35407_CredentialValidator_A01 {
    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is null");
        }
        if ("secret".equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // You can call the validate method with different passwords to test the program
        System.out.println(validate("secret")); // This should print true
        System.out.println(validate("wrongPassword")); // This should print false
        System.out.println(validate(null)); // This should throw an exception
    }
}