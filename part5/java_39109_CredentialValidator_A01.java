public class java_39109_CredentialValidator_A01 {
    public static boolean validate(String username, String password) {
        // Here, we're just checking if the provided username is "admin"
        // and the provided password is "password". In a real application,
        // you'd want to hash the password and compare the hash to the stored hash.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean result = validate("admin", "password");
        if (result) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}