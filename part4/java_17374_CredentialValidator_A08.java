import java.security.cert.X509Certificate;

public class java_17374_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    private String requiredSubject;

    public java_17374_CredentialValidator_A08(String requiredSubject) {
        this.requiredSubject = requiredSubject;
    }

    @Override
    public String getRequestingPrincipal() {
        return null;
    }

    @Override
    public X509Certificate getRequestingCertificate() {
        return null;
    }

    @Override
    public String getRequestingAuditInfo() {
        return null;
    }

    @Override
    public boolean validate(javax.security.auth.credential.Credential credential) throws java.security.AuthenticationException {
        String principal = credential.getPrincipal().toString();
        return principal.equals(this.requiredSubject);
    }
}