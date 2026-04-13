import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04803_XMLParser_A07 extends DefaultHandler {
    private boolean bName;
    private boolean bAge;
    private String strName;
    private int iAge;
    
    public static void main(String[] args) {
        String xml = "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Jane</name>\n" +
                "    <age>25</age>\n" +
                "  </person>\n" +
                "</people>";
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            iAge = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + strName + ", Age: " + iAge);
        }
    }
}