public class java_38362_CredentialValidator_A01 {
    // field to store the stored credential
    private String storedCredential;

    // method to set the credential
    public void setCredential(String credential) {
        this.storedCredential = credential;
    }

    // method to check if the provided credential matches the stored credential
    public boolean isValidCredential(String providedCredential) {
        // check if provided credential is null
        if (providedCredential == null) {
            return false;
        }

        // check if provided credential is the same as the stored credential
        return providedCredential.equals(this.storedCredential);
    }
}