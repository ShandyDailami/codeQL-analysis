public class java_41200_CredentialValidator_A03 {

    public interface Credential {
        String getUsername();
        String getPassword();
    }

    public interface CredentialValidator {
        boolean validate(Credential credential);
    }

    private CredentialValidator validator;

    public java_41200_CredentialValidator_A03(CredentialValidator validator) {
        this.validator = validator;
    }

    public void setValidator(CredentialValidator validator) {
        this.validator = validator;
    }

    public boolean validate(Credential credential) {
        if (validator == null) {
            throw new IllegalStateException("Validator not initialized");
        }
        return validator.validate(credential);
    }

    public static void main(String[] args) {
        // You can use a mock validator for testing purposes
        CredentialValidator mockValidator = new CredentialValidator(new CredentialValidator() {
            @Override
            public boolean validate(Credential credential) {
                String username = credential.getUsername();
                String password = credential.getPassword();

                // You should not do anything here to prevent an injection attack.
                // The purpose of this example is to show how you can handle sensitive data.
                // This should be replaced with your actual logic.
                // For example, check if the password is strong enough.
                if (password.length() < 8) {
                    return false;
                }

                // You should not do anything here to prevent an injection attack.
                // The purpose of this example is to show how you can handle sensitive data.
                // This should be replaced with your actual logic.
                // For example, check if the username contains any special characters.
                if (username.matches(".*[^a-zA-Z0-9].*")) {
                    return false;
                }

                return true;
            }
        });

        // You can use a test credential for testing purposes
        Credential testCredential = new Credential() {
            @Override
            public String getUsername() {
                return "testUser";
            }

            @Override
            public String getPassword() {
                return "testPassword";
            }
        };

        if (mockValidator.validate(testCredential)) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }
    }
}