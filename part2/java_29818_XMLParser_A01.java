import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29818_XMLParser_A01 extends DefaultHandler {
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
            currentElement = null;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyXMLHandler myXMLHandler = new MyXMLHandler();
        saxParser.parse(Main.class.getResourceAsStream("test.xml"), myXMLHandler);
    }
}