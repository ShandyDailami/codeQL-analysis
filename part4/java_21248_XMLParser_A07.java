import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_21248_XMLParser_A07 {

    public static void parse(String xmlFile, MyHandler handler) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/authFailure.xml";
        parse(xmlFile, new MyHandler());
    }
}

class MyHandler extends DefaultHandler {

    private boolean bUsername;
    private boolean bPassword;
    private boolean bAuthFailure;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.transform.dom.DOMElement element)
            throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bUsername) {
            // handle username
        } else if (bPassword) {
            // handle password
        } else if (bAuthFailure) {
            // handle auth failure
        }
    }
}