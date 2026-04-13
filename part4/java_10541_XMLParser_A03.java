import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.StringTokenizer;

public class java_10541_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bValue = false;
    private String tempValue = null;
    private String currentElement = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bName = true;
        tempValue = null;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            bName = false;
            if ("element".equals(currentElement)) {
                System.out.println("Element: " + tempValue);
            }
        } else if (bValue) {
            bValue = false;
            if ("value".equals(currentElement)) {
                System.out.println("Value: " + tempValue);
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            tempValue = new String(ch, start, length);
        } else if (bValue) {
            tempValue += new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        String xmlString = "<root><element>text</element><value>more text</value></root>";
        xmlString = xmlString.replaceAll("<.*?>", ""); // remove all tags
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        SimpleXMLParser handler = new SimpleXMLParser();
        saxParser.parse(new InputSource(new StringReader(xmlString)), handler);
    }
}