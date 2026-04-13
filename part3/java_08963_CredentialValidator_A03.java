import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Iterator;

public class java_08963_CredentialValidator_A03 {

    public static void main(String[] args) throws CertificateException {

        // Load the Java Security Provider
        Provider provider = Security.getProvider("SunJSSE");
        if (provider == null) {
            provider = Security.getProvider("SunCertPathBuilder");
        }
        Security.addProvider(provider);

        // Create a new instance of java.security.cert.Certificate
        Certificate cert = provider.getCertificate("http://www.sun.com");

        // Print the certificate details
        System.out.println("Issuer: " + cert.getIssuer());
        System.out.println("Subject: " + cert.getSubject());
        System.out.println("Not After: " + cert.getNotAfter());
        System.out.println("Not Before: " + cert.getNotBefore());
    }

}