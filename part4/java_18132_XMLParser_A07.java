import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18132_XMLParser_A07 extends DefaultHandler {
    private String lastElement;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
        lastElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            System.out.println("Text inside element: " + new String(ch, start, length));
            lastElement = null;
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            UniqueXMLParser handler = new UniqueXMLParser();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}