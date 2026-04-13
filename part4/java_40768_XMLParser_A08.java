import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.LinkedList;
import java.util.List;

public class java_40768_XMLParser_A08 extends DefaultHandler {
    List<String> tags = new LinkedList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.remove(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!tags.isEmpty()) {
            String tag = tags.get(tags.size() - 1);
            String text = new String(ch, start, length);
            // Security sensitive operation:
            // ...
            System.out.println("Parsed: " + text);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        MySAXHandler mySAXHandler = new MySAXHandler();
        saxParser.parse(Main.class.getResourceAsStream("yourfile.xml"), mySAXHandler);
    }
}