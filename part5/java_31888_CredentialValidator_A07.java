public class java_31888_CredentialValidator_A07 {

    private static String[][] credentials = {
        { "alice", "password1" },
        { "bob", "password2" },
        { "charlie", "password3" }
    };

    public static boolean validateCredentials(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("alice", "password1")); // true
        System.out.println(validateCredentials("bob", "password2")); // true
        System.out.println(validateCredentials("dave", "password1")); // false
    }
}