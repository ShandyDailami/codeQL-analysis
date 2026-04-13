public class java_09302_CredentialValidator_A08 implements CredentialValidator {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public java_09302_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean validate(javax.security.auth.Credential credential) throws javax.security.auth.login.CredentialNotFoundException, javax.security.auth.InvalidCredentialException {
        if (userName.equals(credential.getUsername()) && password.equals(credential.getPassword())) {
            return true;
        } else {
            throw new javax.security.auth.InvalidCredentialException("Invalid credentials");
        }
    }

    public String getChallenge() {
        return null;
    }

    public boolean supported(String option) {
        return true;
    }

}