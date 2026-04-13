public class java_21507_CredentialValidator_A07 {
    public interface CredentialValidator {
        boolean validate(UsernamePasswordCredentials credentials);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(UsernamePasswordCredentials credentials) {
                // This is a simple validation. In a real world application,
                // you would typically query a database or some other external source
                // to check if the provided username and password are valid.
                // This is a placeholder for a real world use case.
                if ("admin".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Use the validator to check if the provided credentials are valid.
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "password");
        if (validator.validate(credentials)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}