import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16860_XMLParser_A01 extends DefaultHandler {

    boolean bName = false;
    boolean bAge = false;
    String currentElement = "";

    public static void main(String[] args) {
        String xml = "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Mary</name>\n" +
                "    <age>28</age>\n" +
                "  </person>\n" +
                "</people>";

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();

            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        if(qName.equalsIgnoreCase("name")) {
            bName = true;
        }
        else if(qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = "";
        if(qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        }
        else if(bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}