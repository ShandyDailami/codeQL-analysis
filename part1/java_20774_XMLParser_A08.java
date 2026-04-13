import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_20774_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("name");

            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                System.out.println("Name: " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}