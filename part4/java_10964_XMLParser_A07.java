import java.xml.parsers.SAXParser;
import java.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10964_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bValue = false;
    private String currentValue = null;

    public static void main(String[] args) {
        String xml = "<doc>\n" +
                "<person id='1'>John Doe</person>\n" +
                "<person id='2'>Jane Doe</person>\n" +
                "</doc>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bValue = false;
            currentValue = "";
        } else {
            currentValue = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bValue = true;
        } else {
            if (bName) {
                System.out.println("Name: " + currentValue);
            }
            if (bValue) {
                System.out.println("Value: " + currentValue);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bValue) {
            currentValue = new String(ch, start, length);
        }
    }
}