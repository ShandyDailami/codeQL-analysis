public class java_35382_CredentialValidator_A03 {

    private static final String VALID_USERNAMES = "admin,user1,user2";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        String[] usernames = VALID_USERNAMES.split(",");

        boolean isValid = false;

        for (String validUsername : usernames) {
            if (validUsername.equals(username)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

}