import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.SAXHelper;

public class java_11040_XMLParser_A03 {
    private static final String MD5 = "MD5";
    private static final String DIGEST = "Digest";
    private static final String ALGORITHM = "SHA-1";

    private SAXHelper saxHelper;

    private MessageDigest getMD5Digest() {
        try {
            return MessageDigest.getInstance(MD5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void parse(String filename) throws Exception {
        InputStream inStream = new FileInputStream(filename);
        saxHelper = new SAXHelper(inStream);
        saxHelper.setContentHandler(new MyContentHandler());
        saxHelper.parse();
    }

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

        String filename = props.getProperty("file");
        if (filename == null) {
            throw new RuntimeException("Missing property: file");
        }

        XMLParser parser = new XMLParser();
        parser.parse(filename);
    }

    private class MyContentHandler extends DefaultHandler {
        private StringBuffer buffer;

        public java_11040_XMLParser_A03() {
            buffer = new StringBuffer();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            buffer.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Implement security-sensitive operations related to A03_Injection
            String content = buffer.toString();
            MessageDigest md = getMD5Digest();
            md.update(content.getBytes());

            // TODO: Use the output of the digest instead of the original content

            // Print out the content
            System.out.println(content);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }
}