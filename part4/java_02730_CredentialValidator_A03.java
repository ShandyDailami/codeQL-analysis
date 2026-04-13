import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_02730_CredentialValidator_A03 {

    public static boolean validate(X509Certificate[] chain, String authType) {
        if (chain == null || chain.length == 0) {
            System.out.println("No certificates in chain!");
            return false;
        }

        X509Certificate cert = chain[0];
        String[] supportedSignatures = {"SHA1WithRSA", "SHA256WithRSA", "SHA384WithRSA"};
        boolean validSignature = Arrays.asList(supportedSignatures).contains(cert.getSigAlgName());

        if (!validSignature) {
            System.out.println("Unsupported signature algorithm: " + cert.getSigAlgName());
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test the validate method with a chain of certificates
        X509Certificate[] chain = new X509Certificate[1];
        chain[0] = null; // replace with a real certificate
        if (validate(chain, "SHA256WithRSA")) {
            System.out.println("Credential validated successfully!");
        } else {
            System.out.println("Credential validation failed!");
        }
    }
}