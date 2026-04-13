import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.NoSuchAlgorithmException;

public class java_30402_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract book details
            NodeList bookList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);
                Element bookElement = (Element) bookNode;

                // Extract details about each book
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String year = bookElement.getElementsByTagName("year").item(0).getTextContent();

                System.out.println("Book Title: " + title);
                System.out.println("Book Author: " + author);
                System.out.println("Book Publication Year: " + year);
            }

            // TODO: Add security-sensitive operations related to A08_IntegrityFailure

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}