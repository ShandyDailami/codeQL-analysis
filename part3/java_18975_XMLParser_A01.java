import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18975_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(xmlFile);

            // Here you can start processing the document.
            // For example, print out all element names:
            doc.getElementsByTagName("*").item(0).getNodeName();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}