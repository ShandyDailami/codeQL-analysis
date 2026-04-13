import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sun.misc.BASE64Decoder;

public class java_40431_XMLParser_A03 extends DefaultHandler {

    private String sha256Hash = null;
    private String username = null;
    private String password = null;
    private String encryptedPassword = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("username") && attributes.getLength() == 0) {
            this.username = attributes.getValue("");
        }
        if (qName.equals("password") && attributes.getLength() == 0) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] digest = md.digest(attributes.getValue(""));
                this.sha256Hash = new String(new BASE64Encoder().encode(digest));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("password")) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] digest = md.digest(this.password);
                this.encryptedPassword = new String(new BASE64Encoder().encode(digest));
                System.out.println("Username: " + this.username);
                System.out.println("Password SHA-256: " + this.sha256Hash);
                System.out.println("Password Encrypted: " + this.encryptedPassword);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.username != null) {
            this.username = new String(ch, start, length);
        }
        if (this.password != null) {
            this.password = new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        String xml = "<data><username>user1</username><password>password1</password></data>";
        XMLParser parser = new XMLParser();
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}