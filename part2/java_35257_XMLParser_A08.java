import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sun.security.x509.X509Certificate;

public class java_35257_XMLParser_A08 {

    private KeyStore keystore;

    public java_35257_XMLParser_A08(String keystorePath, String keystorePassword) throws Exception {
        this.keystore = getKeyStore(keystorePath, keystorePassword);
    }

    private KeyStore getKeyStore(String keystorePath, String keystorePassword) throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream(keystorePath);
        keystore.load(fis, keystorePassword.toCharArray());
        return keystore;
    }

    public List<Certificate> getCertificates(String alias) throws Exception {
        return (List<Certificate>) keystore.getCertificateChain(alias);
    }

    public String getAlias() {
        return keystore.getDefaultCertificateAlias();
    }

    public void parseXML(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFilePath));

            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("*");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Tag: " + element.getTagName());
                System.out.println("Text: " + element.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}