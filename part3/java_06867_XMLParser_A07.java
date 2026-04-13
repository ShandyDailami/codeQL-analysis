import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_06867_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the KeyStore.
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            // Load the TrustStore.
            KeyStore tss = KeyStore.getInstance("JKS");
            tss.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("truststore.jks"), "password".toCharArray());

            // Setup the DocumentBuilderFactory.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setValidating(false);
            dbFactory.setNamespaceAware(false);

            // Setup the DocumentBuilder.
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            dBuilder.setEntityResolver(new MyEntityResolver(tss));

            // Parse the XML file.
            Document doc = dBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("example.xml"));

            // Here goes your code to parse and manipulate the XML document.

        } catch (KeyStoreException e1) {
            e1.printStackTrace();
        } catch (CertificateException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (SAXException e4) {
            e4.printStackTrace();
        }
    }
}