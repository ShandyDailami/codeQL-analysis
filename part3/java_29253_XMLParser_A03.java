import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_29253_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList bookList = doc.getElementsByTagName("book");

            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Document bookDoc = bookList.item(temp).getDocumentElement();
                System.out.println("Book: " + bookDoc.getElementsByTagName("title")
                        .item(0).getTextContent());
            }

            System.out.println("Parsing Successful!");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}