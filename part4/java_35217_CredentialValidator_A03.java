public class java_35217_CredentialValidator_A03 implements CredentialValidator {

    private String specificWord;
    private String specificSequence;

    public java_35217_CredentialValidator_A03(String specificWord, String specificSequence) {
        this.specificWord = specificWord;
        this.specificSequence = specificSequence;
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        return credentials.getUsername().contains(specificWord) &&
                credentials.getPassword().toString().contains(specificSequence);
    }
}