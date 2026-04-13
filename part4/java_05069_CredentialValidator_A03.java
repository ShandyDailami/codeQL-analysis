public class java_05069_CredentialValidator_A03 {
    public boolean isValid(String username, String password) {
        // a simple rule: username must not be null or empty, and password must not be null
        if (username == null || username.isEmpty() || password == null) {
            return false;
        }

        // check if password is weak
        if (password.length() < 8) {
            return false;
        }

        // if we've made it this far, the credentials are valid
        return true;
    }
}