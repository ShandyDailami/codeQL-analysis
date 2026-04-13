import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02938_XMLParser_A01 {

    public void parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(filePath);

            // Here you can manipulate the document object to get information about the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}