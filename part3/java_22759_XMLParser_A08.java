import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_22759_XMLParser_A08 {
    // This is a custom SAX parser that handles XML document with specific schema

    private DefaultHandler defaultHandler;

    public java_22759_XMLParser_A08() {
        defaultHandler = new DefaultHandler();
    }

    public void parseXMLDocument(String xmlFile) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(defaultHandler);
            reader.setErrorHandler(defaultHandler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomSAXParser parser = new CustomSAXParser();
        parser.parseXMLDocument("sample.xml");
    }
}