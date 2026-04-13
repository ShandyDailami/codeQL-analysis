import java.io.File;
import java.io.IOException;
import java.security.CodeSigningException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_39297_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(inputFile, saxHandler);
        } catch (ParserConfigurationException | CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Security-sensitive operation, such as reading or parsing file content
        System.out.println("Start Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Security-sensitive operation, such as closing a connection, log out, etc.
        System.out.println("End Element: " + localName);
    }

    @Override
    public void startDocument(String uri, String localName, String version) throws SAXException {
        // Security-sensitive operation, such as establishing a connection, log in, etc.
        System.out.println("Start Document: " + localName);
    }

    @Override
    public void endDocument(String uri, String localName, String version) throws SAXException {
        // Security-sensitive operation, such as closing a connection, log out, etc.
        System.out.println("End Document: " + localName);
    }

}