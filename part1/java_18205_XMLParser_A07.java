import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

public class java_18205_XMLParser_A07 extends DefaultHandler {
    private String lastElementName = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElementName = qName;
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        lastElementName = null;
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (lastElementName != null) {
            System.out.println("Content: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XMLParser parser = XMLParser.newInstance();
        parser.setContentHandler(new MyXMLParser());

        try {
            parser.parse(Class.forName("org.xml.sax.InputSource").getField("SAX_SOURCE").get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}