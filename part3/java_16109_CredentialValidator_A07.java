public class java_16109_CredentialValidator_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public CredentialValidatorResult validate(CredentialInfo credentialInfo) {
        CredentialValidatorResult result = CredentialValidatorResult.invalid();

        // Assume that we are given the credentials in the form of a CredentialInfo object.
        // In a real-world scenario, you would use this object to get the actual credentials.
        String givenUsername = credentialInfo.getUsername();
        String givenPassword = credentialInfo.getPassword();

        if (USERNAME.equals(givenUsername) && PASSWORD.equals(givenPassword)) {
            result = CredentialValidatorResult.valid();
        }

        return result;
    }
}