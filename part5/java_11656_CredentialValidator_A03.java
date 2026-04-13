public class java_11656_CredentialValidator_A03 {

    // predefined users
    private static final String[][] users = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
        {"user4", "pass4"},
        {"user5", "pass5"}
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

        // test the validator
        System.out.println(validator.validate("user1", "pass1"));  // true
        System.out.println(validator.validate("user6", "pass6"));  // false
    }
}