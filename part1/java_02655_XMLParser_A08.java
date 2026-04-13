import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02655_XMLParser_A08 extends DefaultHandler {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <element1>Content1</element1>\n" +
                "    <element2>Content2</element2>\n" +
                "    <element3>Content3</element3>\n" +
                "</root>";
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SecureXMLParser());
            parser.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) {
        System.out.println("Processing instruction: " + target + ", " + data);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start of prefix mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End of prefix mapping: " + prefix);
    }
}