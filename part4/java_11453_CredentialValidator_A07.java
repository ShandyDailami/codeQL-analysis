public class java_11453_CredentialValidator_A07 implements CredentialValidator {

    private String[][] validCredentials = {
        {"john", "password1"},
        {"mary", "secret2"},
        {"alice", "1234"}
    };

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        for (int i = 0; i < validCredentials.length; i++) {
            if (validCredentials[i][0].equals(username) && validCredentials[i][1].equals(password)) {
                return true;
            }
        }

        throw new InvalidCredentialException("Invalid username or password");
    }
}