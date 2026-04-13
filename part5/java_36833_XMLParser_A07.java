import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36833_XMLParser_A07 extends DefaultHandler {

    private String currentElement;
    private String currentPassword;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("password")) {
            currentPassword = new String(ch, start, length);
        }
    }

    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return new String(digest);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<document>\n" +
                "<password>secret</password>\n" +
                "</document>";

        XMLParser parser = new XMLParser();
        parser.parse(xml);
    }
}