public class java_39991_CredentialValidator_A08 {

    // hard-coded list of credentials
    private static final String[][] credentials = {
        { "alice", "password1" },
        { "bob", "password2" },
        { "charlie", "password3" },
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
        System.out.println(validate("alice", "password1")); // should print true
        System.out.println(validate("alice", "wrongpassword")); // should print false
    }
}