import java.io.File;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_38299_XMLParser_A08 extends DefaultHandler {

    private MessageDigest md;

    public java_38299_XMLParser_A08() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        content = content.trim();
        if (!content.isEmpty()) {
            System.out.println("Content: " + content);
            md.update(content.getBytes());
        }
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public static void main(String[] args) {
        try {
            SAXHelper sax = new SAXHelper();
            MyXMLParser handler = new MyXMLParser();
            sax.setContentHandler(handler);
            File inputFile = new File("input.xml");
            sax.parse(inputFile);
            System.out.println("Checksum: "
                    + convertToHex(handler.getDigest().digest()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public MessageDigest getDigest() {
        return md;
    }
}