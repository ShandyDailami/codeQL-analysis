import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35584_XMLParser_A07 extends DefaultHandler {

    private boolean bUsername = false;
    private boolean bPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, java.util.Properties attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            System.out.println("Username: " + new String(ch, start, length));
            bUsername = false;
        } else if (bPassword) {
            System.out.println("Password: " + new String(ch, start, length));
            bPassword = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(MyXMLParser.class.getResourceAsStream("/mykeystore.jks"), "password".toCharArray());

            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(MyXMLParser.class.getResourceAsStream("/myfile.xml")));
            saxParser.parse(new org.xml.sax.InputSource(MyXMLParser.class.getResourceAsStream("/myfile.xml")), new MyXMLParser());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}