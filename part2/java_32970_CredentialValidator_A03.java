public class java_32970_CredentialValidator_A03 {

    private static final String[] ALLOWED_USERS = {"user1", "user2", "user3"};
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    public boolean validate(String username, String password) {
        for (String allowedUser : ALLOWED_USERS) {
            if (allowedUser.equals(username)) {
                for (String allowedPassword : ALLOWED_PASSWORDS) {
                    if (allowedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}