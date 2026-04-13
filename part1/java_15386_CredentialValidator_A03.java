public class java_15386_CredentialValidator_A03 implements javax.security.auth.credential.Credential {

    private String username;
    private String password;

    public java_15386_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCredential() {
        return this.username + ":" + this.password;
    }

    @Override
    public String getName() {
        return this.username;
    }

    public boolean authenticate(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}