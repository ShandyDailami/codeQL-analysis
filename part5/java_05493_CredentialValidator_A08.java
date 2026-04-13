public class java_05493_CredentialValidator_A08 {

    // Check if the username and password is valid
    public static boolean validate(String username, String password) {
        // Check if the username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Here you can add your own logic to check if the username and password are valid
        // For example, you can check if they match a known username and password
        // This is just a basic check, in a real application you should use secure methods to check the credentials
        return username.equals("admin") && password.equals("password");
    }
}