public class java_28483_CredentialValidator_A01 {
    public static boolean validate(String username, String password) {
        // This is a placeholder. In a real application, you'd typically want to compare
        // the input password to a hashed version of the real password stored in the database
        // and not the password itself.

        // Simulating password validation
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isValid = validate("admin", "password");

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}