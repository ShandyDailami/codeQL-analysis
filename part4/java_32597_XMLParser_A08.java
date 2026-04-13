import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32597_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // create a factory for the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // create a DocumentBuilder to parse the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parse the XML file
            Document doc = builder.parse("sample.xml");
            // Print out the document
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("root"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}