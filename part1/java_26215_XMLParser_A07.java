import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;
import java.net.MalformedURLException;

public class java_26215_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            Class.forName("org.w3c.dom.Document");
            URL url = new File("example.xml").toURI().toURL();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("note");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Node " + (i + 1) + " : " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}