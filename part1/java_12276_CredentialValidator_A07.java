public class java_12276_CredentialValidator_A07 {
    // Dummy user and password
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public Credential validate(String username, String password) {
        // If the inputted username and password match our dummy values
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Return a new Credential object with the inputted username and password
            return new Credential() {
                @Override
                public String getUsername() {
                    return username;
                }

                @Override
                public String getPassword() {
                    return password;
                }
            };
        } else {
            // If the inputted credentials do not match our dummy values, return null
            return null;
        }
    }
}

// This is a dummy interface that represents a Credential object
interface Credential {
    String getUsername();
    String getPassword();
}