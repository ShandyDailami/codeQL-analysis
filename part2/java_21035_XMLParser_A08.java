import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_21035_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml"); // replace with your actual file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            // Here you can start using your xml document.
            // For example, print out the names of all the elements in the document:
            doc.getElementsByTagName("*").item(0).getNodeName();
            
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}