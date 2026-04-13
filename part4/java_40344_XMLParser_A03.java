import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40344_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/example.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer;
        private String tagName;

        MyHandler() {
            buffer = new StringBuffer();
        }

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            buffer.setLength(0);
            tagName = qName;
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (tagName.equalsIgnoreCase("user")) {
                String password = buffer.toString();
                System.out.println("Password: " + password);

                String encryptedPassword = md5Encrypt(password);
                System.out.println("Encrypted Password: " + encryptedPassword);
            }

            System.out.println("End of " + qName);
            tagName = "";
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            buffer.append(chars, start, length);
        }

        private String md5Encrypt(String str) {
            MessageDigest md5 = null;
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            byte[] bytes = md5.digest(str.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(bytes);
        }
    }
}