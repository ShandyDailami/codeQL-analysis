import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28587_XMLParser_A07 extends DefaultHandler {

    private String lastTagName;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
        lastTagName = qName;
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
        lastTagName = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (lastTagName != null && lastTagName.equalsIgnoreCase("authfailure")) {
            System.out.println("AuthFailure: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        AuthFailureXMLParser handler = new AuthFailureXMLParser();
        parser.setContentHandler(handler);
        parser.parse(new java.io.File("src/main/resources/authfailure.xml"), handler);
    }
}