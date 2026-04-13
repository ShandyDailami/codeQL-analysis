import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_27489_CredentialValidator_A08 {
    public boolean validateCredential(X509Certificate[] certs) {
        if (certs == null || certs.length == 0) {
            return false;
        }

        for (X509Certificate cert : certs) {
            if (cert.getSigAlgName().equals("SHA256WithRSA")) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        X509Certificate[] certificates = { /* some certificates here */ };
        System.out.println(validator.validateCredential(certificates));
    }
}