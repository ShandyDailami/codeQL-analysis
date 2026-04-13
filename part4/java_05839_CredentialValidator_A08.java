import javax.security.auth.x500.X500Principal;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import javax.security.auth.login.LoginException;

public class java_05839_CredentialValidator_A08 implements CredentialValidator {

    private X500Principal principal;

    public java_05839_CredentialValidator_A08(X500Principal principal) {
        this.principal = principal;
    }

    @Override
    public String validate(String arg0) throws CredentialInvalidException, LoginException {
        if (arg0 == null || arg0.length() == 0) {
            throw new CredentialInvalidException("Principal name cannot be null or empty.");
        }

        if (!arg0.equals(principal.getName())) {
            throw new CredentialInvalidException("Principal name does not match expected name.");
        }

        return null;
    }

    @Override
    public boolean requiresRequestAuthentication(String arg0) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        X500PrincipalCredentialValidator other = (X500PrincipalCredentialValidator) obj;
        return principal.getName().equals(other.principal.getName());
    }

    @Override
    public int hashCode() {
        return principal.getName().hashCode();
    }
}