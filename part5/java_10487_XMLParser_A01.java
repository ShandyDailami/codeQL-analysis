import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParser;

public class java_10487_XMLParser_A01 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
            currentElement = "";
        } else {
            if (currentElement.equals("name")) {
                bName = false;
            } else if (currentElement.equals("age")) {
                bAge = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String s = new String(ch, start, length);
            System.out.println("Name: " + s);
        } else if (bAge) {
            String s = new String(ch, start, length);
            System.out.println("Age: " + s);
        }
    }
}