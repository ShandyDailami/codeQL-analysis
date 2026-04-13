public class java_38520_CredentialValidator_A08 {

    public boolean validateCredentials(String username, String password) {
        // This is a placeholder. In a real-world scenario, you should use a secure method
        // to compare the entered password with the hashed version stored in the database.
        // For simplicity, this example assumes that the password is correct.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}