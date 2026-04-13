import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28006_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/data.xml", myHandler);

            System.out.println("Data parsed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start of Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Content : " + content);
    }

    @Override
    public void fatalError(org.xml.sax.SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void error(org.xml.sax.SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void warning(org.xml.sax.SAXWarning warning) {
        System.out.println("Warning: " + warning.getMessage());
    }
}