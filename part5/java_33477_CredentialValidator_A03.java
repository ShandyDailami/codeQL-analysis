public class java_33477_CredentialValidator_A03 {

    // hardcoded list of valid users and their passwords
    private static final String[][] validUsers = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };

    public boolean validate(String username, String password) {
        // iterate over the validUsers array
        for (String[] user : validUsers) {
            // if the username and password match a valid user, return true
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        // if no match found, return false
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // test with valid credentials
        System.out.println(validator.validate("user1", "pass1")); // should print true

        // test with invalid credentials
        System.out.println(validator.validate("user4", "pass4")); // should print false
    }
}