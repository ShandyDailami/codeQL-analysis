public class java_12503_CredentialValidator_A01 {
    // This is a simple credential validator that simply checks if the password matches a specific pattern.
    // For simplicity, it only checks if the password is "secret".
    public boolean isValid(String password) {
        return password.equals("secret");
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // This is a test case.
        // If you try to log in with a wrong password, the validator should return false.
        if (validator.isValid("wrongpassword")) {
            System.out.println("Invalid password");
        } else {
            System.out.println("Logged in successfully");
        }
    }
}