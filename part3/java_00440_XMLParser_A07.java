import java.net.URL;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_00440_XMLParser_A07 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        // Your code here
    }

    @Override
    public void endDocument() throws SAXException {
        // Your code here
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            String version) throws SAXException {
        // Your code here
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Your code here
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Your code here
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // Handle error here
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // Handle warning here
    }

    public static void parse(URL url) throws Exception {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new MyXMLParser());
        xr.parse(url.openStream());
    }
}