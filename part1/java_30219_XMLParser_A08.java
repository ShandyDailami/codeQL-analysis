import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_30219_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("elementName"); // replace 'elementName' with the name of the element you want to extract

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Value of element " + (i + 1) + ": " + nodeList.item(i).getTextContent()); // replace 'elementName' with the name of the element you want to extract
        }
    }
}