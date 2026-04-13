public class java_05597_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if username matches specific pattern
        if (username.matches("^[a-zA-Z0-9].*")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String username = "validUser";
        String password = "validPassword";

        boolean isValid = validateCredentials(username, password);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}