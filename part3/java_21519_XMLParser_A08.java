import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21519_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml"; // provide the correct path to your xml file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(fileName);
            // Here you can process the document, for example, check for security failures
            // For the sake of simplicity, let's just print the document's name
            System.out.println(document.getDocumentElement().getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}