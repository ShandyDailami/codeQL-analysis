public class java_35913_CredentialValidator_A08 {

    // This method returns a Credential object.
    public Credential getCredential(String name, String password) {

        Credential credential = new Credential();
        credential.setName(name);
        credential.setPassword(password);

        if (password.length() < 8) {
            credential.setValid(false);
            credential.setMessage("Password is too short. Password must be at least 8 characters long.");
        } else {
            credential.setValid(true);
            credential.setMessage("Credentials are valid.");
        }

        return credential;
    }
}