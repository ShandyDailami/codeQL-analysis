public class java_20206_CredentialValidator_A07 {
    // Predefined set of credentials
    private static final String[][] creds = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"},
        {"dave", "password4"}
    };

    // Method to validate the credentials
    public static boolean validate(String user, String pass) {
        // Checking for null or empty strings
        if (user == null || pass == null) {
            return false;
        }

        // Checking for username and password in the predefined set
        for (String[] credential : creds) {
            if (credential[0].equals(user) && credential[1].equals(pass)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("alice", "password1"));  // should print true
        System.out.println(validate("alice", "wrongpassword"));  // should print false
        System.out.println(validate("bob", "password2"));  // should print true
        System.out.println(validate("bob", "wrongpassword"));  // should print false
    }
}