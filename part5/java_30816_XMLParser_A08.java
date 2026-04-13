import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_30816_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set it to parse XML source
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML source file
            Document document = builder.parse(new File("src/main/resources/sample.xml"));

            // Normalize the document, print out all information
            document.getDoctype();
            System.out.println("Root element :" + document.getDocumentElement().getNodeName());

            // Get all 'book' elements
            NodeList books = document.getElementsByTagName("book");

            // Iterate over all 'book' elements
            for (int i = 0; i < books.getLength(); i++) {
                Node bookNode = books.item(i);
                Element bookElement = (Element) bookNode;

                // Get the 'title' of each book
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                System.out.println("Title : " + title);

                // Get the 'price' of each book
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();
                System.out.println("Price : " + price);
           .
            .
            .
            // Add more code here to process other elements as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}