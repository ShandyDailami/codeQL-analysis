import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12938_XMLParser_A03 extends DefaultHandler {
    private String lastTag;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            System.out.println("Found user: " + attributes.getValue("id"));
            lastTag = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            lastTag = qName;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag.equalsIgnoreCase("user")) {
            System.out.println("Found user name: " + new String(ch, start, length));
        }
    }

    public static void parseXmlFile(String fileName) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        XmlParser handler = new XmlParser();
        saxParser.parse(fileName, handler);
    }

    public static void main(String[] args) {
        try {
            String fileName = "sample.xml";  // provide your own file name
            parseXmlFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}