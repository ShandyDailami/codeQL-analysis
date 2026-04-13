public class java_15534_CredentialValidator_A01 {

    // Simulating a database for credential validation
    private String[][] users = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate Alice's credentials
        if (validator.validate("alice", "password1")) {
            System.out.println("Access granted to Alice");
        } else {
            System.out.println("Access denied for Alice");
        }

        // Validate Bob's credentials
        if (validator.validate("bob", "password2")) {
            System.out.println("Access granted to Bob");
        } else {
            System.out.println("Access denied for Bob");
        }

        // Validate Charlie's credentials
        if (validator.validate("charlie", "password3")) {
            System.out.println("Access granted to Charlie");
        } else {
            System.out.println("Access denied for Charlie");
        }
    }
}