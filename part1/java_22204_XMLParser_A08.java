import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;
import org.xml.sax.XMLReader;

public class java_22204_XMLParser_A08 extends DefaultHandler {
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qualifiedName, ElementListener listener) throws SAXException {
        System.out.println("Start of element: " + qualifiedName);
        listener.warning(null, "Encountered element: " + qualifiedName, "This element has a null or empty value.");
    }

    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        System.out.println("End of element: " + qualifiedName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (length > 0) {
            System.out.println("Element data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new XMLParser());
        try {
            xr.parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}