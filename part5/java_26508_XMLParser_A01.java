import java.awt.print.Book;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import static javax.xml.XML.parseNode;
import javax.xml.parsers.SAXParserFactory;

public class java_26508_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Create a new document
            Document doc = builder.parse(new File("books.xml"));
            
            // Get all the book nodes
            NodeList books = doc.getElementsByTagName("book");
            
            // Loop through each book
            for (int i = 0; i < books.getLength(); i++) {
                Element bookElement = (Element) books.item(i);
                
                // Get the book's details
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();
                
                // Print the book's details
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}