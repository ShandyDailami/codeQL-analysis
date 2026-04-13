import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

public class java_00759_CredentialValidator_A01 {

    private static final String VALID_DOMAIN = "example.com";

    public boolean isValidCertificate(X509Certificate certificate) {
        return isCertificateValid(certificate) && isCertificateFromValidDomain(certificate);
    }

    private boolean isCertificateValid(X509Certificate certificate) {
        Calendar now = Calendar.getInstance();
        Date expiryDate = certificate.getNotAfter();
        Calendar expiry = Calendar.getInstance();
        expiry.setTime(expiryDate);

        return now.before(expiry);
    }

    private boolean isCertificateFromValidDomain(X509Certificate certificate) {
        String[] subjectAlternativeNames = certificate.getSubjectAlternativeNames();

        if (subjectAlternativeNames != null && subjectAlternativeNames.length > 0) {
            for (String alternativeName : subjectAlternativeNames) {
                if (VALID_DOMAIN.equals(alternativeName)) {
                    return true;
                }
            }
        }

        return false;
    }
}