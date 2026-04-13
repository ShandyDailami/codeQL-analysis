import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35067_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and get a new instance of DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file using the builder to get a Document object
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Step 3: Process the document here, e.g., print all element names and text
            doc.getElementsByTagName("*").item(0).getFirstChild().getNodeValue();

        } catch (ParserConfigurationException | SAXException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}