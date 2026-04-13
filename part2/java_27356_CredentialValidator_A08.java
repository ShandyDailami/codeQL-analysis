public class java_27356_CredentialValidator_A08 {

    // Credentials in the form of username:password
    private static final String[][] creds = {
        {"alice", "hello"},
        {"bob", "world"},
        {"charlie", "secret"}
    };

    public static boolean isValid(String username, String password) {
        // Check each credential
        for (String[] cred : creds) {
            if (cred[0].equals(username) && cred[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(isValid("alice", "hello"));  // true
        System.out.println(isValid("bob", "world"));    // true
        System.out.println(isValid("alice", "wrong"));  // false
    }
}