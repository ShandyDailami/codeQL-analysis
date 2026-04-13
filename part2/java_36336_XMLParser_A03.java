import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_36336_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("example.xml");

            // Get the list of books
            NodeList books = doc.getElementsByTagName("book");

            // Iterate over the books
            for (int i = 0; i < books.getLength(); i++) {
                Node bookNode = books.item(i);
                System.out.println("Book " + (i + 1) + ":");
                System.out.println("Title: " + bookNode.getChildNodes().item(1).getTextContent());
                System.out.println("Author: " + bookNode.getChildNodes().item(3).getTextContent());
                System.out.println("Price: " + bookNode.getChildNodes().item(5).getTextContent());
                System.out.println("--------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}