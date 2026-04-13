import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_25713_XMLParser_A08 extends DefaultHandler {

    public java_25713_XMLParser_A08() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(this);
            reader = builder.newSAXReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private XMLReader reader;

    @Override
    public void error(SAXParseException e) {
        System.err.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.err.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) {
        System.err.println("Warning: " + e.getMessage());
    }

    public void parse(String file) {
        try {
            Document doc = reader.read(file);
            // Continue with the parsing of the document...
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyLegacyXMLParser().parse("yourfile.xml");
    }
}