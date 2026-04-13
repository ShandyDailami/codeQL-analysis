import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04876_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(MyXMLParser.class.getResourceAsStream("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bElement = false;
    String thisElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        thisElement = qName;
        bElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println("Element: " + thisElement + ", Content: " + new String(ch, start, length));
        }
    }
}