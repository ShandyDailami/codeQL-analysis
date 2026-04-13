import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02391_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlString = "<root><element>content</element></root>";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            xmlString = Base64.getEncoder().encodeToString(md.digest(xmlString.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("MD5: " + xmlString);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlString);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getElementsByTagName("root").item(0).getTextContent());
            System.out.println("Child element: " + doc.getElementsByTagName("element").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}