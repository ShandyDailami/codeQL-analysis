import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;

public class java_08382_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("authFailure.xml"); // Provide your xml file path here
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("username");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                System.out.println("Username: " + node.getAttribute("username"));

                nodes = doc.getElementsByTagName("password");
                for (int j = 0; j < nodes.getLength(); j++) {
                    Element node2 = (Element) nodes.item(j);
                    System.out.println("Password: " + node2.getAttribute("password"));
               
                    System.out.println("Authentication Failed for User: " + node.getAttribute("username"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}