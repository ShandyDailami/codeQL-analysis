import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07851_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "resources/sample.xml";
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler(filePath));
            parser.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private String filePath;

    public java_07851_XMLParser_A01(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing document...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Document parsing finished.");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) throws SAXException {
        System.out.println("Start element: " + qualifiedName + " [" + localName + "]");
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        System.out.println("End element: " + qualifiedName + " [" + localName + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Text: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }
}