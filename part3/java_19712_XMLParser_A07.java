import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_19712_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // Get the list of book titles
            NodeList bookList = doc.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                String bookTitle = bookList.item(i).getTextContent();
                System.out.println("Book Title: " + bookTitle);
            }

            // Get the list of author names
            NodeList authorList = doc.getElementsByTagName("author");
            for (int i = 0; i < authorList.getLength(); i++) {
                String authorName = authorList.item(i).getTextContent();
                System.out.println("Author Name: " + authorName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}