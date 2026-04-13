public class java_39216_CredentialValidator_A07 implements CredentialValidator {

    // hard-coded credentials
    private static final String CREDENTIALS = "user1/password1\nuser2/password2";
    private static final String USER_PASSWORD_SEPARATOR = "/";

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws AuthenticationException {
        String enteredCredentials = arg0.getIdentifier();
        String userName = "";
        String password = "";

        // parse entered credentials
        for (String s : CREDENTIALS.split(USER_PASSWORD_SEPARATOR)) {
            String[] userPassArr = s.split("\\r?\\n");
            userName = userPassArr[0];
            password = userPassArr[1];

            // if entered credentials match, return true
            if (enteredCredentials.equals(userName) && enteredCredentials.equals(password)) {
                return true;
            }
        }
        return false;
    }
}