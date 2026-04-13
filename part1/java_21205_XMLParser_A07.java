import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_21205_XMLParser_A07 extends DefaultHandler {
    private String lastElementName;
    private String lastElementContent;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("authFailure")) {
            System.out.println("Found auth failure: " + localName);
        }
        lastElementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastElementName)) {
            if (lastElementName.equals("authFailure")) {
                // Handle the content of the authFailure element here
                System.out.println("Auth failure content: " + lastElementContent);
            }
        }
        lastElementName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElementName != null) {
            lastElementContent = new String(ch, start, length);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new AuthFailureHandler());
        reader.parse("sample.xml");
    }
}