import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_30185_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("books.xml"));

            // Use the DOM Builder to traverse through the document
            NodeList nodeList = doc.getElementsByTagName("book");

            // Print out the title and author of each book
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element node = (Element) nodeList.item(temp);
                String title = node.getElementsByTagName("title").item(0).getTextContent();
                String author = node.getElementsByTagName("author").item(0).getTextContent();
                System.out.println("Book: " + title + ", Author: " + author);
            }

            // Close the document
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}