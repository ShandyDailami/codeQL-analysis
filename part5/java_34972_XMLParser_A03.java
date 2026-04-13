import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34972_XMLParser_A03 extends DefaultHandler {

    private String lastElementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No action in this example, just indicate end of element
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No action in this example, just print the text
        if (lastElementName != null) {
            String text = new String(ch, start, length);
            System.out.println(lastElementName + ": " + text);
            lastElementName = null;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MinimalistXMLParser());
            parser.parse(MinimalistXMLParser.class.getResourceAsStream("example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}