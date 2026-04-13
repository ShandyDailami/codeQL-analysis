public class java_12346_CredentialValidator_A03 implements CredentialValidator {
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"pass1", "pass2", "pass3"};

    @Override
    public boolean validate(String username, String password) {
        for (int i = 0; i < USERS.length; i++) {
            if (USERS[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}