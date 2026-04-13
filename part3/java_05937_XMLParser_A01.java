import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_05937_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Creating a factory for XML parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Creating a builder for XML parsing
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the XML file
            Document doc = builder.parse(new File("books.xml"));

            // Getting the root element
            Element root = doc.getDocumentElement();

            // Getting all book elements
            NodeList books = root.getElementsByTagName("book");

            // Printing all book information
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                Element element = (Element) book;

                // Printing book title
                System.out.println("Book Title: " + element.getElementsByTagName("title").item(0).getTextContent());

                // Printing book author
                System.out.println("Book Author: " + element.getElementsByTagName("author").item(0).getTextContent());

                // Printing book price
                System.out.println("Book Price: " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}