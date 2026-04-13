public class java_04774_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        // Placeholder for real database operations
        // In a real scenario, you would want to compare the user's input against the
        // actual database.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";
        if (validate(username, password)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}