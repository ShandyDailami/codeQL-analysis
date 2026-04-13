import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

public class java_27864_CredentialValidator_A08 {
    // The certificate used to verify the credential.
    private X509Certificate certificate;

    public java_27864_CredentialValidator_A08(X509Certificate certificate) {
        this.certificate = certificate;
    }

    // A method to validate the credential.
    public boolean validateCredential() {
        // The validity period of the credential is from the current date until 5 years from now.
        Date validityPeriodStart = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(validityPeriodStart);
        c.add(Calendar.YEAR, 5);
        Date validityPeriodEnd = c.getTime();

        // The credential must be validated within the validity period.
        if (certificate.getNotAfter().after(validityPeriodStart) && certificate.getNotBefore().before(validityPeriodEnd)) {
            return true;
        } else {
            return false;
        }
    }
}