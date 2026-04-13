import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_28444_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("path/to/your/file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Handle the document here, for example, print all element names
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}