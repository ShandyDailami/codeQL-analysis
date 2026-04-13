import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_12690_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<user password='mypassword'>John Doe</user>";
        String password = "mypassword";

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XmlHandler xh = new XmlHandler();
            sp.parse(xml, xh);
            String encodedPassword = encodePassword(password);
            if (xh.isPasswordCorrect(encodedPassword)) {
                System.out.println("Password is correct!");
            } else {
                System.out.println("Password is incorrect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class XmlHandler implements SAXHandler {
    private String password;

    public boolean startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("password")) {
            password = attributes.getValue("href");
        }
        return true;
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
    }

    public boolean isPasswordCorrect(String encodedPassword) {
        return encodedPassword.equals(encodePassword(password));
    }
}