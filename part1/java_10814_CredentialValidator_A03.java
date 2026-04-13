public class java_10814_CredentialValidator_A03 implements CredentialValidator {

    private List<String> validUsers;

    public java_10814_CredentialValidator_A03() {
        validUsers = new ArrayList<>();
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        if (credentials == null) {
            throw new IllegalArgumentException("UsernamePasswordCredentials is null");
        }

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (validUsers.contains(username) && checkPassword(password)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }

    private boolean checkPassword(String password) {
        // Here you can implement your password validation logic.
        // For simplicity, let's assume all passwords are valid
        return true;
    }
}