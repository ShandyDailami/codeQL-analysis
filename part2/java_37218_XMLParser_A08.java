import java.io.File;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class java_37218_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            MyHandler mh = new MyHandler();
            sp.parse(new File("sample.xml"), mh);

            // Verify integrity
            String expected = getDigest("sample.xml");
            String actual = mh.getDigest();
            if (expected.equals(actual)) {
                System.out.println("Integrity is checked successfully.");
            } else {
                System.out.println("Integrity check failed.");
            }
        } catch (IOException | SAXException | ParserConfigurationException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // MessageDigest is a part of java.security package
    static String getDigest(String fileName) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            File file = new File(fileName);
            byte[] bytes = new byte[1024];
            int length;
            FileInputStream fis = new FileInputStream(file);
            while ((length = fis.read(bytes)) != -1) {
                md.update(bytes, 0, length);
            }
            fis.close();
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Utility method to convert byte[] to hexadecimal string
    static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >> 4) & 0xF, 16));
            sb.append(Character.forDigit((b & 0xF), 16));
        }
        return sb.toString();
    }
}

class MyHandler extends SAXParser {
    private String digest;

    public void startDocument() throws SAXException {
        // Do nothing
    }

    public void endDocument() throws SAXException {
        // Do nothing
    }

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // Do nothing
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Do nothing
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Update the digest with the characters read
        digest = getDigest(ch, start, length);
    }

    // Method to update digest
    private String getDigest(char[] ch, int start, int length) {
        return bytesToHex(ch, start, length);
    }

    // Method to update digest
    private String getDigest(String str) {
        return getDigest(str.toCharArray(), 0, str.length());
    }

    public String getDigest() {
        return this.digest;
    }

}