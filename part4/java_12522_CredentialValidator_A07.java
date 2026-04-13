public class java_12522_CredentialValidator_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        // Check if both usernames and passwords are not null
        if (username == null || password == null) {
            return false;
        }

        // Check if provided username and password match predefined values
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

}