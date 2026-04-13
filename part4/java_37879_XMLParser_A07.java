import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_37879_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<data><user id='1'><name>John</name><email>john@example.com</email></user><user id='2'><name>Bob</name><email>bob@example.com</email></user></data>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            doc.getDocumentElement().normalize();

            NodeList users = doc.getElementsByTagName("user");

            for (int i = 0; i < users.getLength(); i++) {
                Node userNode = users.item(i);
                String userId = userNode.getAttributes().getNamedItem("id").getTextContent();
                String name = userNode.getElementsByTagName("name").item(0).getTextContent();
                String email = userNode.getElementsByTagName("email").item(0).getTextContent();

                System.out.println("User ID: " + userId);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}