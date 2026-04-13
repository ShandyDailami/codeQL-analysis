import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_18104_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a new document using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("books.xml"));

            // Get the book list
            NodeList bookList = doc.getElementsByTagName("book");
            
            // Iterate over each book
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                Element bookElement = (Element) bookNode;
                
                // Extract and print the book's details
                String title = bookElement.getAttribute("title");
                String author = bookElement.getAttribute("author");
                String price = bookElement.getAttribute("price");
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}