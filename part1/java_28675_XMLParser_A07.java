import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

public class java_28675_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            URL url = new URL("http://example.com/sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url.openStream());

            // Get all the <book> elements
            NodeList bookNodes = document.getElementsByTagName("book");

            // Security-sensitive operation: Print all book titles
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Node bookNode = bookNodes.item(i);
                Element bookElement = (Element) bookNode;
                System.out.println("Book Title: " + bookElement.getAttribute("title"));
            }

            // Security-sensitive operation: Print book price
            System.out.println("Book Price: " + document.getElementsByTagName("price").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}