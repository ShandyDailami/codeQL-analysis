import java.security.Provider;
import java.security.Security;

public class java_20902_CredentialValidator_A07 {
    public static void main(String[] args) {
        // Create the credential validator
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        if (validator.validate("testPassword")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public java_20902_CredentialValidator_A07() {
        // Add the custom provider
        Provider provider = new MyProvider();
        Security.addProvider(provider);
    }

    public boolean validate(String password) {
        // Check if the password matches the hard-coded pattern
        return password.equals("testPassword");
    }

    // Custom provider
    static class MyProvider extends java.security.Provider {
        private final static String DESCRIPTION = "My custom provider";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }

        @Override
        public String choose(String key, String[] values) {
            return values[0]; // Return the first value
        }

        @Override
        public String choosePassword(String key, char[] chars, int off, int len) {
            return new String(chars, off, len); // Return the password as a string
        }

        @Override
        public String[] getKeys() {
            return new String[] {};
        }
    }
}