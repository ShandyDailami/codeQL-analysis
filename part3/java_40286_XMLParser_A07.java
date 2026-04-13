import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40286_XMLParser_A07 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element " + qName);
        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element " + qName);
        System.out.println("Data: " + data.toString());
    }

    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            XmlParser handler = new XmlParser();
            saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}