import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30171_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            MyXMLParser handler = new MyXMLParser();
            sp.parse(MyXMLParser.class.getResourceAsStream("/sample.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                if (qName.equals("name")) {
                    bName = false;
                }
            }

            if (bAge) {
                if (qName.equals("age")) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String value = new String(ch, start, length);
            System.out.println("Name: " + value);
        }

        if (bAge) {
            String value = new String(ch, start, length);
            System.out.println("Age: " + value);
        }
    }
}