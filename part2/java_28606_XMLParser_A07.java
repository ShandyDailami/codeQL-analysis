import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28606_XMLParser_A07 extends DefaultHandler {
    private boolean bAuthFailure = false;
    private boolean bUser = false;
    private boolean bPassword = false;
    private StringBuffer sUser;
    private StringBuffer sPassword;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            bUser = true;
            sUser = new StringBuffer();
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
            sPassword = new StringBuffer();
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            bUser = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUser) {
            sUser.append(ch, start, length);
        } else if (bPassword) {
            sPassword.append(ch, start, length);
        }
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}