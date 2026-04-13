public class java_18484_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();
        // Minimum length of password is 8 characters.
        if (password.length() >= 8) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> getUsernames(UsernamePasswordCredential credential) {
        // This method is not used in this specific case.
        return new ArrayList<>();
    }

    @Override
    public List<CredentialValidationResult> validateCredentials(
            List<UsernamePasswordCredential> credentials) {
        List<CredentialValidationResult> results = new ArrayList<>();
        for (UsernamePasswordCredential credential : credentials) {
            if (validate(credential)) {
                results.add(new CredentialValidationResult(
                        CredentialValidationResult.State.SUCCESS));
            } else {
                results.add(new CredentialValidationResult(
                        CredentialValidationResult.State.FAILURE,
                        "Invalid password. Password must be at least 8 characters long."));
            }
        }
        return results;
    }
}