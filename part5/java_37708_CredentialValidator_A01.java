public class java_37708_CredentialValidator_A01 {

    private CredentialRepository credentialRepository;

    public java_37708_CredentialValidator_A01(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean isValid(String username, String password) {
        // a. Remove this comment if you are going to use the result of the method
        // b. Remove this comment if you are going to use the result of the method

        // c. The CredentialRepository class has methods to get user and password from a database.
        // d. We use the methods to get the user and password from the database.
        Credential credential = credentialRepository.getCredential(username);

        // e. If the Credential object is null, return false.
        // f. If the Credential object is not null, then check the password using the isValidPassword method.
        // g. If the password is valid, then return true. Otherwise, return false.
        if(credential == null) {
            return false;
        } else {
            return isValidPassword(credential, password);
        }
    }

    private boolean isValidPassword(Credential credential, String password) {
        // a. Remove this comment if you are going to use the result of the method
        // b. Remove this comment if you are going to use the result of the method

        // c. The Credential class has a method to check if the given password matches the hashed password in the Credential object.
        // d. We use the method to check if the given password matches the hashed password in the Credential object.
        // e. If the passwords match, then return true. Otherwise, return false.
        return credential.isValidPassword(password);
    }

    // a. Remove this comment if you are going to use the CredentialRepository class in the CredentialValidator class.
    // b. Remove this comment if you are going to use the CredentialValidator class in the CredentialRepository class.
    public void setCredentialRepository(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }
}