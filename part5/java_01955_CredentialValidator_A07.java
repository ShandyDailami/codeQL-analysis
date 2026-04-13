public class java_01955_CredentialValidator_A07 implements CredentialValidator {

    // The hardcoded username and password
    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    @Override
    public boolean validate(InputStream credential) throws AuthenticationException {
        // Create a reader object
        Properties props = new Properties();

        // Load the properties file
        try {
            props.load(credential);
        } catch (IOException e) {
            throw new AuthenticationException("Failed to load properties");
        }

        // Get the provided username and password
        String providedUsername = props.getProperty("username");
        String providedPassword = props.getProperty("password");

        // Validate the provided credentials
        if(hardcodedUsername.equals(providedUsername) && hardcodedPassword.equals(providedPassword)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}