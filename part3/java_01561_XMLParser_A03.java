import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01561_XMLParser_A03 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and an instance of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Parse the XML from the resource file
        Document document = null;
        try {
            document = builder.parse("src/main/resources/sample.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 3: Use the document object for security-sensitive operations related to A03_Injection
        // In this case, we're just selecting the first element with a specific name
        Element element = document.getElementsByTagName("element").item(0);
        String elementName = element.getAttribute("name");

        // Step 4: Log the result
        System.out.println("Element Name: " + elementName);
    }
}