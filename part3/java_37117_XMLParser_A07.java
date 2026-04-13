import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_37117_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(XmlParser.class.getResourceAsStream("/user.xml"));
            document.getDocumentElement().normalize();

            NodeList userNodes = document.getElementsByTagName("user");

            for (int i = 0; i < userNodes.getLength(); i++) {
                Element userElement = (Element) userNodes.item(i);

                String username = userElement.getElementsByTagName("username").item(0).getTextContent();
                String password = userElement.getElementsByTagName("password").item(0).getTextContent();

                if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                    System.out.println("Username or password is empty");
                    continue;
                }

                // You can add security-sensitive operations here...

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}