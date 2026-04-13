import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_40119_XMLParser_A03 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("input.xml"));
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("name");
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                System.out.println("Name: " + node.getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}