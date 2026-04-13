public class java_32870_CredentialValidator_A08 {
    public static boolean validate(String username, String password) {
        // For the sake of this example, we'll check if the username is "admin" and the password is "password".
        // In a real application, you'd want to store these in a secure way and compare them against user input.
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        // Test the validate method.
        boolean isValid = validate("admin", "password");
        if (isValid) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }
}