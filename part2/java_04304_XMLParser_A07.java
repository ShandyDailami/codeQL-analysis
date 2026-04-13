import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04304_XMLParser_A07 extends DefaultHandler {
    public boolean isInElement = false;
    public String currentElement = "";

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            System.out.println("Content: " + new String(ch, start, length));
        }
    }
}