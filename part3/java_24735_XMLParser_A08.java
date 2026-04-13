import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_24735_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseXML("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        InputStream inputStream = new FileInputStream(fileName);
        Document document = builder.parse(inputStream);

        document.getDocumentElement().normalize();

        NodeList nodes = document.getElementsByTagName("node");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element nodeElement = (Element) nodes.item(i);

            String attribute = nodeElement.getAttribute("attribute");
            String value = nodeElement.getAttribute("value");

            System.out.println("Attribute: " + attribute);
            System.out.println("Value: " + value);
        }
    }
}