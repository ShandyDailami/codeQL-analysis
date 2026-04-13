import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39344_XMLParser_A08 extends DefaultHandler {

    private String lastElement;
    private String lastValue;

    public void startDocument() throws SAXException {
        System.out.println("Starting document...");
    }

    public void endDocument() throws SAXException {
        System.out.println("Ending document...");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        lastValue = "";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            System.out.println("Element: " + lastElement + ", Value: " + lastValue);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        lastValue = new String(ch, start, length);
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = new SAXParser();
            MessageDigest md = MessageDigest.getInstance("MD5");
            InputStream inputStream = new FileInputStream("sample.xml");
            XmlParser handler = new XmlParser();
            saxParser.setContentHandler(handler);
            saxParser.parse(inputStream);

            // Checking the integrity of the XML document.
            byte[] digest = md.digest(inputStream.toString().getBytes());
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(0xff & digest[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("XML integrity: " + hexString.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}