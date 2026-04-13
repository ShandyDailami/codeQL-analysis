import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_39581_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set it to parse XML files
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Iterate over each child element of the root element
            for (int i = 0; i < root.getChildNodes().getLength(); i++) {
                Element element = (Element) root.getChildNodes().item(i);

                // Extract the name and value of each element
                String name = element.getNodeName();
                String value = element.getFirstChild().getNodeValue();

                // Print the element's name and value
                System.out.println("Name: " + name);
                System.out.println("Value: " + value);
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}