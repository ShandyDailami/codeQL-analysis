import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05443_XMLParser_A01 extends DefaultHandler {

    private String lastElementName;

    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age><city>New York</city></person>";
        XMLParser parser = new XMLParser();
        parser.parse(xml);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastElementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        lastElementName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (lastElementName != null) {
            // Perform security-sensitive operation related to A01_BrokenAccessControl
            // For example, print the content if the last element is "name"
            if (lastElementName.equals("name")) {
                System.out.println(new String(ch, start, length));
            }
            lastElementName = null;
        }
    }
}