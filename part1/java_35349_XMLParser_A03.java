import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_35349_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract book names
            NodeList bookList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);
                Element bookElement = (Element) bookNode;
                String bookName = bookElement.getAttribute("name");
                System.out.println("Book Name : " + bookName);

                // Extract author name
                NodeList authorList = bookElement.getElementsByTagName("author");
                for (int j = 0; j < authorList.getLength(); j++) {
                    Node authorNode = authorList.item(j);
                    Element authorElement = (Element) authorNode;
                    String authorName = authorElement.getTextContent();
                    System.out.println("Author Name : " + authorName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}