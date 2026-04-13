public class java_00797_CredentialValidator_A03 {

    public boolean isValid(String username, String password) {
        // If the username or password is empty, it's not valid
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // If the username and password are the same, they're not unique
        if (username.equals(password)) {
            return false;
        }

        // If none of the above conditions were met, the credentials are valid
        return true;
    }
}