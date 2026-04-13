public class java_09674_CredentialValidator_A07 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validateCredentials(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        // This is just a simple validation for now.
        // In a real application, you would need to use a secure hash function
        // to compare the password with the hash of the stored password.
        return username.equals("admin") && password.equals("password");
    }
}