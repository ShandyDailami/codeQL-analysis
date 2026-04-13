import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_34698_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXML("data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File(fileName));

        doc.getDocumentElement().normalize();

        NodeList nodes = doc.getElementsByTagName("user");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("User: " + node.getAttributes().getNamedItem("name").getTextContent());

            Element element = (Element) node;

            String password = element.getAttributes().getNamedItem("password").getTextContent();

            // Hash the password using MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(password.getBytes());

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }

            System.out.println("Hashed password: " + hexString.toString());
        }

        printToXML(doc, "modified.xml");
    }

    private static void printToXML(Document doc, String fileName) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        // Result is written to a file named output.xml
        StreamResult result = new StreamResult(new File(fileName));

        transformer.transform(source, result);
    }
}