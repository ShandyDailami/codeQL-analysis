import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00019_XMLParser_A08 extends DefaultHandler {

    private boolean bTag = false;
    private String currentValue = "";

    public static void main(String[] args) {
        String input = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(new StringReader(input), handler);
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
        bTag = true;
        currentValue = "";
        System.out.print("Start of element " + qName + "\n");
    }

    @Override
    public java_00019_XMLParser_A08(String uri, String localName, String qName) {
        bTag = false;
        System.out.println("End of element " + qName + "\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bTag) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}