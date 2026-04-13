import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_22020_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get all book nodes
            NodeList bookList = doc.getElementsByTagName("book");

            // Print book info
            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);

                // Get book info
                Element bookElement = (Element) bookNode;
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Book Title: " + title + ", Price: " + price);
            }

            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}