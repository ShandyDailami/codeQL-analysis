import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29603_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        File file = new File(fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true); // Enable validation

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Document elements: " + doc.getElementsCount());

            NodeList nodeList = doc.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getNodeName());
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}