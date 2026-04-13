import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_02304_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load a CertificateFactory
            CertificateFactory cf = CertificateFactory.getInstance("PKIX");

            // Load a KeyStore
            KeyStore ks = KeyStore.getInstance("JKS");
            InputStream is = new FileInputStream("mykeystore.jks");
            ks.load(is, "mypassword".toCharArray());

            // Load a Certificate
            Certificate cert = cf.generateCertificate(is);
            ks.setCertificateEntry("mycert", cert);

            // Create a KeyStore containing our trusted Certificate
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(null, null);
            trustStore.setCertificateEntry("mycert", cert);

            // Set the new KeyStore and TrustStore in our SAXParser
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setValidate(true);
            spf.setNamespaceAware(true);
            spf.setXIncludeSchemaResolver(new MyXIncludeSchemaResolver());
            SAXParser saxp = spf.newSAXParser();
            saxp.setDefaultHandler(new MySAXHandler());

            // Parse the XML file
            saxp.parse(new File("myfile.xml"), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}