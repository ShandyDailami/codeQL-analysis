import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16368_XMLParser_A08 {
    public static void main(String[] args) {
        // Create DocumentBuilderFactory instance
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            Document doc = builder.parse(new File("books.xml"));

            // Print book titles
            doc.getElementsByTagName("title").item(0).getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNodeValue());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}