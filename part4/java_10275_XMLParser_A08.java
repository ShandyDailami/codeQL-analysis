import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicErrorHandler;

public class java_10275_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = new SAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParser);
            xmlReader.setErrorHandler(new BasicErrorHandler());
            xmlReader.parse("src/data.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParser implements org.xml.sax.ContentHandler {

    private boolean isInElement = false;
    private String currentElement = null;

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName) {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            String content = new String(ch, start, length);
            // Do something with the content of the element
            // This is where you would place the security-sensitive operations
        }
    }

    @Override
    public void error(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void warning(SAXException e) {
        e.printStackTrace();
    }
}