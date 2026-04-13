import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34856_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Parse the document
            Document doc = dBuilder.parse(new File("sample.xml"));
            // Get all the elements
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                // Extract the book title
                String bookTitle = nodeList.item(temp).getElementsByTagName("title").item(0).getTextContent();
                // Extract the book author
                String bookAuthor = nodeList.item(temp).getElementsByTagName("author").item(0).getTextContent();
                System.out.println("Book Title: " + bookTitle);
                System.out.println("Book Author: " + bookAuthor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}