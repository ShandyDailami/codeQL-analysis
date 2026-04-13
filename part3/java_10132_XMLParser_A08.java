import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10132_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to parse the input file and build a new Document object
            Document doc = builder.parse(new File("books.xml"));

            // Get the book list element
            doc.getDocumentElement().normalize();
            System.out.println("Books:");

            NodeList bookList = doc.getElementsByTagName("book");

            // Iterate over each book
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                Element bookElement = (Element) bookNode;

                // Extract and print book title
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                System.out.println("Title: " + title);
            }

            // Close the DocumentBuilder
            ((DocumentBuilder) builder).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}