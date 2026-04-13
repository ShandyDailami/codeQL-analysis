import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_37037_XMLParser_A01 extends DefaultHandler {

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }
}

public class MySAXParser {

    public static void parse(String filename) {
        try {
            File inputFile = new File(filename);
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new XMLReaderFactory());
            XMLReader myHandler = saxParser.getXMLReader();
            myHandler.setContentHandler(new MySAXHandler());
            myHandler.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("brokenaccesscontrol.xml");
    }
}