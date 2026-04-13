import java.security.AuthFailureException;
import java.security.AuthenticationException;
import java.security.Security;

public class java_17202_CredentialValidator_A07 implements java.security.Authenticator {
    private String myRealm;

    public java_17202_CredentialValidator_A07(String realm) {
        myRealm = realm;
    }

    public java.security.Authenticator getAuthenticator() {
        return this;
    }

    public java.security.Principal getPrincipals(String arg0) throws AuthenticationException {
        return null;
    }

    public java.security.Authentication getAuthentication() throws AuthenticationException {
        return null;
    }

    public String getAuthMethod() {
        return "CUSTOM";
    }

    public void successfulAuthentication(Authentication auth, java.security.AccessControl access) throws AuthFailureException {
        // No operations in successful authentication.
    }

    public void unsuccessfulAuthentication(String arg0, String arg1, java.security.AuthenticationException arg2) {
        throw new AuthenticationException("Invalid Credentials");
    }
}