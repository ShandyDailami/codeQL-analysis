import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_10759_XMLParser_A03 extends DefaultHandler {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXReaderFactory readerFactory = SAXReaderFactory.newInstance();
            XMLReader reader = readerFactory.getXMLReader(new MyXMLParser());
            reader.setContentHandler(new MyXMLParser());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    @Override
    public void warning(SAXWarning warning) throws SAXException {
        System.out.println("Warning: " + warning.getMessage());
    }
}