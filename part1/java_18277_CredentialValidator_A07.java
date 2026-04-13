import java.security.Principal;

public class java_18277_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private String username = "user";
    private String password = "password";

    @Override
    public Principal validate(javax.security.auth.credential.Credential credential) {
        String user = credential.getIdentifier();
        String pass = credential.getCredential();

        if(user.equals(this.username) && pass.equals(this.password)) {
            return new Principal() {
                @Override
                public String getName() {
                    return user;
                }
            };
        } else {
            return null;
        }
    }
}