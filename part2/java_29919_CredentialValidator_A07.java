public class java_29919_CredentialValidator_A07 {

    // A pre-defined set of credentials
    private static String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
    };

    public static boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1") ? "Access granted" : "Access denied");
        System.out.println(validate("user5", "password5") ? "Access granted" : "Access denied");
    }
}