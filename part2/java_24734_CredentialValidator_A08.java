public class java_24734_CredentialValidator_A08 {

    public boolean validate(String username, String password) {
        // Hardcoded passwords for simplicity
        if ("user1".equals(username) && "password1".equals(password)) {
            return true;
        }
        if ("user2".equals(username) && "password2".equals(password)) {
            return true;
        }

        // In a real-world application, you would not want to hardcode passwords.
        // Instead, you would want to store them in a secure way and check them against the provided password.
        return false;
    }
}