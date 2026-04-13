import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_34707_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("your_file.xml"));

            // Get the root element of the document
            Element root = document.getDocumentElement();

            // Print out the data from each element
            printElementData(root);
        } catch (ParsingException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to print out the data from each element
    private static void printElementData(Element element) {
        // Print the element's name
        System.out.println("Element name: " + element.getNodeName());

        // Print the element's attributes
        if (element.hasAttributes()) {
            System.out.println("Attributes: ");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println(element.getAttributes().getItem(i).getNodeName() + ": " +
                        element.getAttributes().getItem(i).getNodeValue());
            }
        }

        // Print the element's children
        if (element.hasChildNodes()) {
            System.out.println("Children: ");
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE) {
                    System.out.println(((Text) element.getChildNodes().item(i)).getNodeValue());
                } else {
                    printElementData((Element) element.getChildNodes().item(i));
                }
            }
        }
    }
}