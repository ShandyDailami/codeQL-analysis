import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

public class java_34402_XMLParser_A03 extends DefaultHandler {

    private String lastElementName = null;
    private String lastNamespaceURI = null;
    private String lastLocalName = null;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        lastElementName = localName;
        lastNamespaceURI = uri;
        lastLocalName = localName;
        System.out.println("Start of element: " + localName + " at " + uri);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElementName = qName;
        lastNamespaceURI = uri;
        lastLocalName = localName;
        System.out.println("End of element: " + localName + " at " + uri);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElementName != null && lastNamespaceURI != null) {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str + " in element: " + lastElementName + " at " + lastNamespaceURI + " (" + lastLocalName + ")");
        }
    }

    public static void main(String[] args) {
        XMLParser parser = XMLParser.newInstance();
        MyXMLParser handler = new MyXMLParser();
        parser.setContentHandler(handler);
        try {
            parser.parse("sample.xml"); // Replace with the path to your XML file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}