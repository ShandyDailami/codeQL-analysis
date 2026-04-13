import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_29847_XMLParser_A03 extends DefaultHandler {
    private String curTag;

    public void startDocument() throws SAXException {
        System.out.println("Start of document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document.");
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        curTag = qName;
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        curTag = "";
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (curTag != null) {
            String content = new String(ch, start, length);
            System.out.println("Content in " + curTag + ": " + content);
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(parser);
            xr.parse("src/injection.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}