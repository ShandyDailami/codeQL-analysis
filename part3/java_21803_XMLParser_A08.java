import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_21803_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print the data from the XML file
            printData(doc);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("element"); // replace "element" with the actual tag name

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            System.out.println("Element " + (i + 1) + ":");
            System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Value: " + element.getElementsByTagName("value").item(0).getTextContent());
            System.out.println("------------------------");
        }
    }
}