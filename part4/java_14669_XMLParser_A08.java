import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14669_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAtrrName = false;
    private boolean bValue = false;
    private String currElement = "";
    private String currAttrName = "";

    public static void main(String[] args) {
        String fileName = "sample.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyXMLHandler myHandler = new MyXMLHandler();
            saxParser.parse(fileName, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currElement = qName;
        bName = true;
        bAtrrName = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currElement.equalsIgnoreCase("element")) {
            bName = false;
        } else if (currElement.equalsIgnoreCase("attribute")) {
            bAtrrName = false;
        }
        currElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Element: " + new String(ch, start, length));
        } else if (bAtrrName) {
            System.out.println("Attribute name: " + new String(ch, start, length));
        } else if (bValue) {
            System.out.println("Attribute value: " + new String(ch, start, length));
        }
    }
}