import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_24878_XMLParser_A03 extends DefaultHandler {

    private String thisElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement != null) {
            String elementContent = new String(ch, start, length);
            System.out.println(thisElement + ": " + elementContent);
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyXMLParser myHandler = new MyXMLParser();
            saxParser.parse(Class.forName("org.xml.sax.InputSource").getMethod("forName", String.class).invoke(null, "test.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}