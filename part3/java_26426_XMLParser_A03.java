import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26426_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml";
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);

            // perform security-sensitive operations related to injection here
            String injection = createInjection(document);
            System.out.println(injection);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String createInjection(Document document) {
        // Create an injection string and return it
        String injection = "Injected from XML Parser: " + document.getDocumentElement().getNodeName();
        return injection;
    }
}