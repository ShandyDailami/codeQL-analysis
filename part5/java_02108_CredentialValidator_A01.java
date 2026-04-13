public class java_02108_CredentialValidator_A01 {
    // This is a simple example of a credential validator.
    // It validates the username and password based on certain rules.

    public boolean isValid(String username, String password) {
        // Here, we're assuming that the valid username and password are always 'admin' and 'password'
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Validated successfully!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }
}