import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_40489_CredentialValidator_A08 {

    private static final String PROVIDER_NAME = "BC";

    public static void main(String[] args) {
        Provider provider = Security.getProvider(PROVIDER_NAME);
        if (provider == null) {
            System.out.println("No provider found with name " + PROVIDER_NAME);
            return;
        }

        try {
            Certificate cert = provider.getCertificate(args[0]);
            validateCertificate(cert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateCertificate(Certificate cert) {
        try {
            CertificateValidator.validate(cert, false);
            System.out.println("Certificate is valid!");
        } catch (CertificateException e) {
            System.out.println("Certificate is not valid!");
        }
    }

}