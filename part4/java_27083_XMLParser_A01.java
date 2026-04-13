import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27083_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Initialize DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Initialize DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse("sample.xml");

            // Step 4: Process the parsed XML
            // This is where you could implement security-sensitive operations
            // For example, we can print out the XML document's title
            System.out.println("Title: " + doc.getElementsByTagName("title").item(0).getTextContent());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}