public class java_17862_CredentialValidator_A01 implements CredentialValidator {

    private static final String USER_DB = "databaseUser";
    private static final String PASS_DB = "databasePassword";

    @Override
    public CredentialValidationResult validate(Credential c) throws IllegalArgumentException {
        if (c == null || c.getCredential() == null) {
            throw new IllegalArgumentException("Null credentials");
        }

        String username = c.getUsername();
        String password = c.getPassword();

        // In a real-world application, you would typically use a database to compare the user and password.
        // This is just for the sake of example
        if (USER_DB.equals(username) && PASS_DB.equals(password)) {
            return new CredentialValidationResult(true, "Valid Credentials");
        } else {
            return new CredentialValidationResult(false, "Invalid Credentials");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new SimpleCredentialValidator();

        // Using the validator to validate credentials
        Credential cred = new UsernamePasswordCredential("databaseUser", "wrongPassword");
        CredentialValidationResult result = validator.validate(cred);
        System.out.println(result.isValid() ? "Validated successfully" : "Failed to validate");
    }
}