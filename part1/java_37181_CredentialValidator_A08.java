public class java_37181_CredentialValidator_A08 {

    // The real validation method.
    public boolean validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // Here we're assuming a basic validation - if username or password is not correct, return false.
        // In a real-world application, you'd typically want to hash and salt the password, and check the hashed password against the salt.
        return !(username.equals("admin") && password.equals("password"));
    }

    // A simple wrapper around the validation method.
    public boolean isValid(String username, String password) {
        return validate(username, password);
    }
}