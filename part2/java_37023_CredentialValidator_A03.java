public class java_37023_CredentialValidator_A03 {

    public static boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        // You can write your own validation logic here
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        // You can write your own validation logic here
        return true;
    }

    public static boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            System.out.println("Invalid username");
            return false;
        }
        if (!isValidPassword(password)) {
            System.out.println("Invalid password");
            return false;
        }
        return true;
    }
}