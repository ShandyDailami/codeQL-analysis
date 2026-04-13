import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00256_XMLParser_A07 extends DefaultHandler {

    private boolean isUser;
    private String currentElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        if (qName.equalsIgnoreCase("user")) {
            isUser = true;
        } else {
            isUser = false;
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        if (qName.equalsIgnoreCase("user")) {
            isUser = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUser) {
            String userData = new String(ch, start, length).trim();
            if(!userData.isEmpty()) {
                System.out.println("User Data: " + userData);
            }
        }
    }
}