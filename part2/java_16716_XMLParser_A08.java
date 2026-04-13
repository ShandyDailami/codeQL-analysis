import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16716_XMLParser_A08 extends DefaultHandler {

    private String lastTag = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = null;
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag != null) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new CustomXMLParser());

            // Sample XML data
            String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<root>\n" +
                    "    <message>Hello, World!</message>\n" +
                    "    <id>12345</id>\n" +
                    "</root>";

            saxParser.parse(new StringReader(xmlData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}