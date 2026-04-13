import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30458_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bValue = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("value")) {
            bValue = true;
        }
    }

    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bValue) {
            System.out.println("Value: " + new String(ch, start, length));
            bValue = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(Class.forName("org.xml.sax.InputSource").getField("NAMESPACE").get(null).getClass().getResourceAsStream("/example.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}