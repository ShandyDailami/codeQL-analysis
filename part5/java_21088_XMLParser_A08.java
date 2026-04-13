import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_21088_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ReaderHandler handler = new ReaderHandler();
            reader.setContentHandler(handler);
            reader.parse(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReaderHandler implements org.xml.sax.ContentHandler {
    boolean bIntegrityFailure = false;

    @Override
    public void startDocument() {
        // Do nothing
    }

    @Override
    public void endDocument() {
        // Do nothing
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        // Do nothing
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Check for integrity failure
        if (new String(ch, start, length).trim().length() > 0) {
            bIntegrityFailure = true;
        }
    }

    @Override
    public void error(SAXException e) {
        // Do nothing
    }

    @Override
    public void fatalError(SAXException e) {
        // Do nothing
    }

    @Override
    public void warning(SAXException e) {
        // Do nothing
    }
}