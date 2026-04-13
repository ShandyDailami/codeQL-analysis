import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;

public class java_05901_XMLParser_A08 {
    private static final String MD5 = "MD5";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        String salt = new BigInteger(160, sr).toString(16);

        MessageDigest md5 = MessageDigest.getInstance(MD5);
        md5.update(salt.getBytes());

        String generatedPassword = new String(Base64.getEncoder().encode(md5.digest(salt.getBytes())));

        try {
            XMLParser parser = new XMLParser(new MyHandler());
            parser.parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, java.util.Properties attributes) throws SAXException {
            // do something with the start element
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do something with the end element
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do something with the characters
        }
    }
}