public class java_02128_CredentialValidator_A01 {

    public boolean validateCredentials(String username, String password) {
        // Normally, passwords should be hashed and salted for storage, not stored in plain text.
        // For the sake of this example, we'll just check if the password is "password".
        if (password.equals("password")) {
            System.out.println("Valid credentials");
            return true;
        } else {
            System.out.println("Invalid credentials");
            return false;
        }
    }
}