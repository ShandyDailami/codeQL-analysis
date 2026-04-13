import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12116_XMLParser_A03 {

    public static void main(String[] args) {
        String url = "path_to_your_xml_file"; // replace with your xml file path
        parseXML(url);
    }

    public static void parseXML(String url) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(url));

            // Print out the XML file
            document.getDoctype();
            System.out.println("Root element : " + document.getDocumentElement().getNodeName());

            // Process XML here...
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}