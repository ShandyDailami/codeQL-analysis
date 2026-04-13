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

public class java_08105_XMLParser_A08 {
    private String xmlFilePath;
    private KeyStore keyStore;

    public java_08105_XMLParser_A08(String xmlFilePath, KeyStore keyStore) {
        this.xmlFilePath = xmlFilePath;
        this.keyStore = keyStore;
    }

    public void parse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new File(xmlFilePath)));
            saxParser.setContentHandler(new MyContentHandler());
            saxParser.parse(new File(xmlFilePath), new org.xml.sax.helpers.DefaultHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    private class MyContentHandler extends DefaultHandler {
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
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String value = new String(ch, start, length);
            System.out.println("Value of element: " + value);
        }
    }
}