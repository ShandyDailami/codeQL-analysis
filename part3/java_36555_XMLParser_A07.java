import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36555_XMLParser_A07 extends DefaultHandler {

    private int elementCount = 0;

    private String currentElement = null;

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        elementCount++;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        currentElement = null;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (currentElement != null) {
            // Ignore whitespace between elements
            if (currentElement.length() > 0) {
                System.out.println(currentElement);
            }
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        if (!inputFile.exists()) {
            throw new InvalidParameterException("Input file does not exist");
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            LegacyXMLParser handler = new LegacyXMLParser();
            saxParser.parse(inputFile, handler);

            System.out.println("Element Count: " + handler.getElementCount());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public int getElementCount() {
        return elementCount;
    }
}