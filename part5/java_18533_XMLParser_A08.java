import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18533_XMLParser_A08 {

    public static void main(String[] args) {
        // Setup XML Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse XML File
        Document doc = null;
        try {
            doc = builder.parse(new File("src/main/resources/data.xml"));
        } catch (SAXException | IOException | CertificateException e) {
            e.printStackTrace();
        }

        // Setup XPath
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        String expression = "/data/name";

        // Execute XPath and Print out the results
        try {
            System.out.println(xpath.evaluate(expression, doc, XPathConstants.NODESET));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}