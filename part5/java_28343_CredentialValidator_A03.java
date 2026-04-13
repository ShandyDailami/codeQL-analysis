public class java_28343_CredentialValidator_A03 {

    private String[] validUsernames = {"admin", "user1", "user2"};
    private String[] validPasswords = {"password1", "password2", "password3"};

    public boolean validate(String username, String password) {
        boolean isValidUsername = false;
        boolean isValidPassword = false;

        for (String user : validUsernames) {
            if (user.equals(username)) {
                isValidUsername = true;
                break;
            }
        }

        for (String pass : validPasswords) {
            if (pass.equals(password)) {
                isValidPassword = true;
                break;
            }
        }

        return isValidUsername && isValidPassword;
    }
}