import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_36619_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        SAXDriver saxDriver = new SAXDriver();
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        SAXHandler saxHandler = new SAXHandler();
        xmlReader.setContentHandler(saxHandler);

        saxDriver.setOutStage(true);
        saxDriver.parse(xmlReader, "/path/to/your/xml/file.xml");
    }
}

class SAXHandler implements org.xml.sax.ContentHandler {
    boolean bName = true;
    String strName = "";

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startElement(String uri, String localName, String qName)
        throws SAXException {
        if (qName.equalsIgnoreCase("name"))
            bName = true;
        else
            bName = false;
    }

    public void endElement(String uri, String localName, String qName)
        throws SAXException {
    }

    public void characters(char ch[], int start, int length)
        throws SAXException {
        if (bName)
            strName = new String(ch, start, length);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    public void warning(String warning) throws SAXException {
        System.out.println("Warning: " + warning);
    }
}