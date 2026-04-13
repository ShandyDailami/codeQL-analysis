import java.security.Principal;

public class java_07657_CredentialValidator_A07 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public Principal validate(String user, String password) {
                if (isValid(user, password)) {
                    return new UserPrincipal(user);
                } else {
                    throw new AuthFailureException("Invalid username or password");
                }
            }

            private boolean isValid(String user, String password) {
                // Assume we have a method isValid() to check if user and password are valid
                return isValid(user, password);
            }
        };

        // Use the validator
        // ...
    }

    // Internal class to hold user principal
    static class UserPrincipal implements Principal {
        private String name;

        public java_07657_CredentialValidator_A07(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}