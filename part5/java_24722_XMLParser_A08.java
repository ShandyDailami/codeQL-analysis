import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_24722_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";
    private String name = "";
    private int age = 0;
    
    public static void main(String[] args) {
        String xml = "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Alice</name>\n" +
                "    <age>25</age>\n" +
                "  </person>\n" +
                "</people>";
        MyXMLParser parser = new MyXMLParser();
        parser.parse(new StringReader(xml));
    }

    public void parse(Reader r) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(r);
            saxParser.setContentHandler(this);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("name")) bName = true;
        else if (qName.equals("age")) bAge = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println("Name: " + name + ", Age: " + age);
            name = "";
            age = 0;
        } else if (qName.equals("people")) {
            // nothing to do
        } else if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
    }
}