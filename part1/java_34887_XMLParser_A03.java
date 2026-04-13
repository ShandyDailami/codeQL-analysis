import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

public class java_34887_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new File("example.xml").toURI().toURL();
            parse(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(URL url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(url.openStream());

        doc.getDocumentElement().normalize();
        List<Node> nodes = doc.getElements();

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Tag: " + element.getTagName());
                System.out.println("Attributes: " + element.getAttributes());
            }
        }
    }
}