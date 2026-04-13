public class java_37849_CredentialValidator_A01 {
    // Use a class to validate login credentials.

    // Define a static inner class to encapsulate the validation logic.
    public static class CredentialValidatorImpl implements CredentialValidator {

        private final String username;
        private final String password;

        public java_37849_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean isValid() {
            // Simulate a database lookup for username and password.
            // The below code is a placeholder and will fail.
            // In a real-world scenario, a more complex validation logic should be implemented.
            return username.equals("admin") && password.equals("password");
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }

    // Use a class to validate login credentials.
    public static class CredentialValidator {

        // Define a static inner class to encapsulate the validation logic.
        public static class CredentialValidatorImpl implements CredentialValidator {

            private final String username;
            private final String password;

            public java_37849_CredentialValidator_A01(String username, String password) {
                this.username = username;
                this.password = password;
            }

            @Override
            public boolean isValid() {
                // Simulate a database lookup for username and password.
                // The below code is a placeholder and will fail.
                // In a real-world scenario, a more complex validation logic should be implemented.
                return username.equals("admin") && password.equals("password");
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getPassword() {
                return password;
            }
        }
    }
}