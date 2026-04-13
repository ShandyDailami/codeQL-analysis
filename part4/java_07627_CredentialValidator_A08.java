public class java_07627_CredentialValidator_A08 {

    // predefined credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    // check if credentials are valid
    public boolean isValid(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // if the credentials are not valid, throw an exception
    public void throwIfInvalid(String username, String password) {
        if (!isValid(username, password)) {
            throw new SecurityException("Invalid username or password");
        }
    }

    // main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.throwIfInvalid("wrongUser", "wrongPassword"); // should throw exception
            validator.throwIfInvalid("user", "pass"); // should not throw exception
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}