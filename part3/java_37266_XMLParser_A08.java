import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37266_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "path/to/your/xml/file.xml";
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // True to parse as case-sensitive
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(filePath), myHandler);
        } catch (ParserConfigurationException | SAXException | IOException | NoSuchAlgorithmException | KeyStoreException | CertificateException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of XML Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of XML Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }

    }

}