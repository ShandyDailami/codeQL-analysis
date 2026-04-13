import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23781_XMLParser_A01 extends DefaultHandler {

    private static final String SAMPLE_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<document>\n" +
                    "<user name=\"user1\" password=\"pass1\" />\n" +
                    "<user name=\"user2\" password=\"pass2\" />\n" +
                    "</document>";

    private String lastUser;
    private String lastPassword;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            lastUser = attributes.getValue("name");
            lastPassword = attributes.getValue("password");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("document")) {
            // Here you can add your security-sensitive operations related to A01_BrokenAccessControl
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastUser != null && lastPassword != null) {
            // Here you can add your security-sensitive operations related to A01_BrokenAccessControl
        }
    }

    public static void main(String[] args) {
        SecurityChecker handler = new SecurityChecker();
        org.xml.sax.XMLReader reader = org.xml.sax.SAXReader.newInstance();
        reader.setContentHandler(handler);
        try {
            reader.parse(org.xml.sax.InputSource.fromString(SAMPLE_XML));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}