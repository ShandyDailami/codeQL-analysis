import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_23626_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Extract and print data
            NodeList nodes = doc.getElementsByTagName("student");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element e = (Element) node;
                String name = e.getElementsByTagName("name").item(0).getTextContent();
                String id = e.getElementsByTagName("id").item(0).getTextContent();
                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}