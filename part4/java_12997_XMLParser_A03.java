import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_12997_XMLParser_A03 extends DefaultHandler {
    private boolean isName = false;
    private boolean isAge = false;
    private String name;
    private int age;

    public static void main(String[] args) {
        String xml = "<people>\n" +
                "    <person>\n" +
                "        <name>John</name>\n" +
                "        <age>20</age>\n" +
                "    </person>\n" +
                "    <person>\n" +
                "        <name>Jane</name>\n" +
                "        <age>25</age>\n" +
                "    </person>\n" +
                "</people>";
        new MyXMLParser().parse(xml);
    }

    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXSource(new StringReader(xml)));
            parser.setContentHandler(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("age")) {
            isAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isName) {
            name = new String(ch, start, length);
            isName = false;
        } else if (isAge) {
            age = Integer.parseInt(new String(ch, start, length));
            isAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}