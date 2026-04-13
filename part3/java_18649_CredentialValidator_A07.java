import java.security.AuthFailureException;
import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_18649_CredentialValidator_A07 implements java.security.Authenticator {
    private String myPassword;

    public java_18649_CredentialValidator_A07(String password) {
        myPassword = password;
    }

    @Override
    public Credential authenticate(String var1, String var2) throws AuthFailureException {
        if (var2.equals(myPassword)) {
            return new javax.security.auth.DestroyableCredential() {
                public boolean commit() {
                    return true;
                }

                public void reset() throws GeneralSecurityException {
                }

                public String getId() {
                    return var1;
                }
            };
        } else {
            throw new AuthFailureException("Invalid password");
        }
    }
}