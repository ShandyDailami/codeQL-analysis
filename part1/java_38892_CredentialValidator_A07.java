public class java_38892_CredentialValidator_A07 implements CredentialValidator {

    private String[] usernames;

    public java_38892_CredentialValidator_A07() {
        // This is a placeholder. In a real application, the usernames should come from a real database.
        usernames = new String[] {"admin", "user1", "user2", "user3", "user4", "user5"};
    }

    @Override
    public boolean validate(String username, String password) {
        for (String user : usernames) {
            if (user.equals(username)) {
                return true;
            }
        }
        return false;
    }
}