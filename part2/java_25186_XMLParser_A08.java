import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_25186_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourxmlfile.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(xmlFile);

            // Get all 'item' nodes
            NodeList items = document.getElementsByTagName("item");

            // Print all 'item' nodes
            for (int i = 0; i < items.getLength(); i++) {
                System.out.println(items.item(i).getTextContent());
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}