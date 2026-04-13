import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.Iterator;

public class java_12280_CredentialValidator_A08 {

    // The validation method
    public boolean validateCertificate(X509Certificate cert, X509Extension ext) {
        if (cert == null || ext == null) {
            return false;
        }

        Iterator<X509Extension> extIterator = ext.getExtensions().iterator();
        while (extIterator.hasNext()) {
            X509Extension nextExt = extIterator.next();
            // Compare the extension type and value with expected values
            if (!nextExt.getOID().equals(ext.getOID()) ||
                !nextExt.getValue().equals(ext.getValue())) {
                return false;
            }
        }

        return true;
    }
}