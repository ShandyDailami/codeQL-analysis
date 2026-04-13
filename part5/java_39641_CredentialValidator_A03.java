public class java_39641_CredentialValidator_A03 {

    // This is a mock password. In a real-world scenario,
    // it should be hashed and stored securely.
    private static final String MOCK_PASSWORD = "mock_password";

    public boolean validate(String username, String password) {
        // Here, we'll just check if the username and password
        // match our mock values. In a real-world scenario,
        // you'd want to use a more secure way of comparing passwords.
        return username.equals("admin") && password.equals(MOCK_PASSWORD);
    }
}