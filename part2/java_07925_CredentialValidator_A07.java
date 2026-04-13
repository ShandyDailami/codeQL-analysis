import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;

public class java_07925_CredentialValidator_A07 {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());
        }

        Security.addProvider(new CustomProvider());

        try {
            X509Certificate[] chain = ((javax.security.auth.callback.UnsupportedCallbackException)
                    CustomCertificateCallback.requestCertificate(null, "localhost", null, null, null)).getChain();
            for (X509Certificate certificate : chain) {
                System.out.println("Certificate: " + certificate.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}