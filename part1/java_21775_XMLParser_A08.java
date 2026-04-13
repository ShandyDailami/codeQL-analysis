import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_21775_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get all the <book> nodes
            NodeList bookList = doc.getElementsByTagName("book");

            // Print out the book details
            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    // print book id
                    System.out.println("Book ID : " + bookElement.getAttribute("id"));
                    // print book name
                    System.out.println("Book Name : " + bookElement.getElementsByTagName("name").item(0).getTextContent());
                    // print book price
                    System.out.println("Book Price : " + bookElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("----------------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}