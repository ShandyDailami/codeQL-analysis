import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04068_XMLParser_A03 {

    public static void parseXML(String fileName) {

        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the input XML file and store in the Document object
            Document document = builder.parse(fileName);

            // Step 4: Handle the XML document object
            // ...

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML("example.xml");
    }
}