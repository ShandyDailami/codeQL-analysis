import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10857_XMLParser_A08 extends DefaultHandler {
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastElement)) {
            System.out.println("End of " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equals(localName)) {
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MyXMLHandler myHandler = new MyXMLHandler();
        saxParser.parse(Class.forName("org.xml.sax.InputSource").getMethod("forName", String.class).invoke(null, "org.xml.sax.InputSource"), myHandler);
    }
}