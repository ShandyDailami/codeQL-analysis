import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27243_XMLParser_A03 {
    private String xmlContent;

    public java_27243_XMLParser_A03(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public Document parseXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Remove the following lines to prevent the parsing process from being intercepted by a malicious user.
        // This is a basic demonstration and can be improved by using proper security measures.
        // In this case, we are only disabling the XML external entity parsing.
        builder.setEntityResolver(new MyEntityResolver());

        Document document = null;
        try {
            document = builder.parse(new InputSource(new StringReader(xmlContent)));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        return document;
    }

    // Implementing MyEntityResolver as a placeholder for a more secure solution.
    class MyEntityResolver extends EntityResolver {
        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            // Disable parsing of external entities to prevent injection attacks.
            return new InputSource(new StringReader(""));
        }
    }
}