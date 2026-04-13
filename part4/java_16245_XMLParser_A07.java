import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16245_XMLParser_A07 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, CertificateException, KeyStoreException {
        FileInputStream fis = new FileInputStream("src/main/resources/sample.xml");
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(fis, "password".toCharArray());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder(ks.getKeyStoreDocument());

        Document doc = builder.parse("");
        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Element: " + node.getNodeName());
            System.out.println("Value: " + node.getTextContent());
        }
    }
}