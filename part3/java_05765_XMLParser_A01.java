import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05765_XMLParser_A01 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age></person>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SecureXMLParser handler = new SecureXMLParser();
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            // Do something with the name
            System.out.println(new String(ch, start, length));
        } else if (bAge) {
            // Do something with the age
            System.out.println(new String(ch, start, length));
        }
    }
}