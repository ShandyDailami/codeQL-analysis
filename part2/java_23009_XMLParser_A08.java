import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_23009_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml"));

            // Print the parsed information
            printData(doc);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root Element: " + root.getNodeName());

        // Get the value of the first <name> element
        Element name = (Element) root.getElementsByTagName("name").item(0);
        System.out.println("Name: " + name.getTextContent());

        // Get the value of the first <age> element
        Element age = (Element) root.getElementsByTagName("age").item(0);
        System.out.println("Age: " + age.getTextContent());
    }
}