public class java_06565_CredentialValidator_A03 {

    // predefined list of users and their passwords
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"pass1", "pass2", "pass3"};

    // method to validate the username and password
    public boolean validate(String username, String password) {
        for (int i = 0; i < USERS.length; i++) {
            if (USERS[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // test the validator
        boolean isValid = validator.validate("user1", "pass1");
        if (isValid) {
            System.out.println("Credentials validated successfully!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}