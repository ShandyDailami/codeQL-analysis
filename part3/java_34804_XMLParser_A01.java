import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_34804_XMLParser_A01 {
    public static void main(String[] args) {
        // Load the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File("books.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the root element
        Element root = doc.getDocumentElement();

        // Get all book elements
        NodeList books = root.getElementsByTagName("book");

        // Iterate over all books
        for (int i = 0; i < books.getLength(); i++) {
            Node bookNode = books.item(i);
            Element bookElement = (Element) bookNode;

            // Get book attributes
            String title = bookElement.getAttribute("title");
            String author = bookElement.getAttribute("author");

            System.out.println("Book " + (i + 1) + ": " + title + " by " + author);
        }
    }
}