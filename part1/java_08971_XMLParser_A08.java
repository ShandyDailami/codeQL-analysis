import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_08971_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("books.xml"));

            // Make sure the root element is 'Books'
            if (!doc.getDocumentElement().getNodeName().equals("Books")) {
                System.out.println("Invalid XML: Root element is not 'Books'");
                return;
            }

            // Verify the integrity of the XML data
            NodeList bookNodes = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Node bookNode = bookNodes.item(i);

                // Check 'Title' and 'Author' elements
                if (!bookNode.getChildNodes().item(0).getNodeName().equals("Title")) {
                    System.out.println("Invalid XML: Book " + (i + 1) + " has invalid 'Title' element");
                    return;
                }
                if (!bookNode.getChildNodes().item(1).getNodeName().equals("Author")) {
                    System.out.println("Invalid XML: Book " + (i + 1) + " has invalid 'Author' element");
                    return;
                }

                // Check 'Price' element
                if (!bookNode.getChildNodes().item(2).getNodeName().equals("Price")) {
                    System.out.println("Invalid XML: Book " + (i + 1) + " has invalid 'Price' element");
                    return;
                }
            }

            System.out.println("All books are valid");

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}