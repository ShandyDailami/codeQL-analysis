import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXParseException;

public class java_38034_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/bookstore.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList bookNodes = document.getElementsByTagName("book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                System.out.println("Book " + (i + 1));
                Node bookNode = bookNodes.item(i);

                NodeList bookInfoNodes = bookNode.getChildNodes();
                for (int j = 0; j < bookInfoNodes.getLength(); j++) {
                    Node bookInfoNode = bookInfoNodes.item(j);
                    System.out.println("  " + bookInfoNode.getNodeName() + ": " + bookInfoNode.getTextContent());
                }
            }
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Parsing error: " + e.getMessage());
        }
    }
}