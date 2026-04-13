import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class java_11875_CredentialValidator_A08 implements javax.security.auth.x500.X500PrincipalValidator {

    private static final String SUPERVISOR_DN = "CN=SuperVisor,OU=OrgUnit,O=OrgName";
    private static final String ADMIN_DN = "CN=Admin,OU=OrgUnit,O=OrgName";
    private static final String USER_DN = "CN=User,OU=OrgUnit,O=OrgName";

    @Override
    public String getPrincipal(String arg0) throws CertificateException, IllegalArgumentException {
        return arg0;
    }

    @Override
    public String getIssuer(String arg0) throws CertificateException, IllegalArgumentException {
        return arg0;
    }

    @Override
    public X509Certificate[] getCertificateChain(String arg0) throws CertificateException, IllegalArgumentException {
        return null;
    }

    @Override
    public void validate(String arg0) throws CertificateException, IllegalArgumentException {
        // Assume that the DNs are valid if they are one of the predefined ones
        if (arg0.equals(SUPERVISOR_DN) || arg0.equals(ADMIN_DN) || arg0.equals(USER_DN)) {
            // Everything is fine, continue...
        } else {
            throw new CertificateException("Invalid credentials");
        }
    }
}