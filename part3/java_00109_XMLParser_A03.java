import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXElement;
import org.xml.sax.helpers.DefaultHandler;

public class java_00109_XMLParser_A03 {

    private static final String SHA_256 = "SHA-256";

    private static String getSHA256Hash(String input) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(SHA_256);
        byte[] hash = md.digest(input.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        File file = new File("path_to_your_xml_file");

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            FileInputStream fis = new FileInputStream(file);
            LegacyXMLHandler handler = new LegacyXMLHandler();
            sp.parse(fis, handler);

            System.out.println("XML File Hash: " + getSHA256Hash(file.toString()));
            System.out.println("XML Content Hash: " + getSHA256Hash(handler.getContent()));

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class LegacyXMLHandler extends DefaultHandler {
        private StringBuffer content;

        public java_00109_XMLParser_A03() {
            content = new StringBuffer();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            content.append(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            content.append("/");
            content.append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(new String(ch, start, length));
        }

        public String getContent() {
            return content.toString();
        }
    }
}