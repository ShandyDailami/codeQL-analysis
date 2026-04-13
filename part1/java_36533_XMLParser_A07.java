import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.net.URL;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_36533_XMLParser_A07 {

    private DefaultHandler handler;

    public java_36533_XMLParser_A07() {
        handler = new DefaultHandler();
    }

    public void parse(String file) throws ParserConfigurationException, SAXException {
        String systemId = file;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(new StringReader(systemId));
            }
        });
        builder.setErrorHandler(handler);
        try (InputStream is = new FileInputStream(systemId)) {
            builder.parse(new InputSource(is), handler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SAXParserExample parser = new SAXParserExample();
        try {
            parser.parse("src/main/resources/example.xml");
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}