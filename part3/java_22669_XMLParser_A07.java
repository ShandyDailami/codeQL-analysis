import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22669_XMLParser_A07 extends DefaultHandler {
    boolean bAuthFailure = false;

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MyXMLParser parser = new MyXMLParser();
        saxParser.parse("src/main/resources/authfailure.xml", parser);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            // Do something with the data here.
            System.out.println(new String(ch, start, length));
        }
    }
}