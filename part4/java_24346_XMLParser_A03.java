import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24346_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("sample.xml"));

            NodeList nodes = doc.getElementsByTagName("injection");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Injection detected in node " + (i + 1));
                System.out.println("Attempting injection: " + node.getTextContent());
                // Realistically, this is a serious security risk and not recommended for production use.
                // The following line is a simple example of a security risk.
                // You should replace this with a secure method of injection.
                String injection = node.getTextContent();
                System.out.println("Injected value: " + injection);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}