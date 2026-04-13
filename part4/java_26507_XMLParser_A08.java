import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26507_XMLParser_A08 extends DefaultHandler {

    private boolean bElementFound = false;
    private String currentElement = "";
    private StringBuilder elementValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bElementFound = true;
        elementValue = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle the element
        if (bElementFound) {
            bElementFound = false;
            handleElement(currentElement, elementValue.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue.append(new String(ch, start, length));
    }

    private void handleElement(String element, String elementValue) {
        // Handle element and its value, here is a simple example of handling
        System.out.println("Element: " + element + ", Value: " + elementValue);
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        XMLParser handler = new XMLParser();
        saxParser.parse(XMLParser.class.getResourceAsStream("test.xml"), handler);
    }
}