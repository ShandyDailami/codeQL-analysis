import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40113_XMLParser_A08 extends DefaultHandler {
    private boolean inPerson = false;
    private boolean inName = false;
    private boolean inAge = false;
    private String currentElement = null;
    
    public static void main(String[] args) {
        String xml = "<people>\n" +
                     "  <person id=\"1\">\n" +
                     "    <name>John</name>\n" +
                     "    <age>30</age>\n" +
                     "  </person>\n" +
                     "  <person id=\"2\">\n" +
                     "    <name>Mary</name>\n" +
                     "    <age>28</age>\n" +
                     "  </person>\n" +
                     "</people>";
        MyXMLParser parser = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new StringReader(xml), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        currentElement = qName;

        if (qName.equals("person")) {
            inPerson = true;
        } else if (inPerson) {
            if (qName.equals("name")) {
                inName = true;
            } else if (qName.equals("age")) {
                inAge = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        currentElement = null;

        if (qName.equals("person")) {
            inPerson = false;
        } else if (inPerson) {
            if (qName.equals("name")) {
                inName = false;
            } else if (qName.equals("age")) {
                inAge = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inPerson && inName && currentElement != null) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (inPerson && inAge && currentElement != null) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}