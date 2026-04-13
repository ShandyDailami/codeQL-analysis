import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29747_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Setup the DocumentBuilder to parse the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.File("src/main/resources/authfailure.xml"));

            // Process the document here, for example, print all the elements
            document.getElementsByTagName("AuthFailure").item(0).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}