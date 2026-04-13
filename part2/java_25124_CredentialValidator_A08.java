public class java_25124_CredentialValidator_A08 {

    // predefined set of credentials
    private static String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    // method to validate credentials
    public boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = "password1";

        if (validator.validate(username, password)) {
            System.out.println("Access granted for user " + username);
        } else {
            System.out.println("Access denied for user " + username);
        }
    }
}