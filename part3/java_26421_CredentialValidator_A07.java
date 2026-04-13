public class java_26421_CredentialValidator_A07 {

    // Pre-defined set of credentials
    private static String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"}
    };

    // Method to authenticate user
    public static boolean authenticate(String username, String password) {
        boolean isValid = false;

        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid username or password");
        }

        return isValid;
    }

    public static void main(String[] args) {
        // Test the authenticate method
        authenticate("user1", "password1");
        authenticate("user5", "password5");
    }
}