import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37670_XMLParser_A07 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystore_password";
    private static final String KEY_ALIAS = "key_alias";

    public static void main(String[] args) {
        try {
            loadKeyStore();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }

        try {
            parseXml();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void loadKeyStore() throws IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        Files.readAllLines(new File(KEYSTORE_PATH).toPath()).stream().forEach(line -> {
            if (line.startsWith("password")) {
                KeyStoreUtils.loadKeyStore(KEYSTORE_PATH, KEY_ALIAS, KEYSTORE_PASSWORD, line.split("password: ")[1]);
            }
        });
    }

    private static void parseXml() throws ParserConfigurationException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, javax.xml.schemas.org.xml.ns.Schema.Attribute[] attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };
        saxParser.parse(new File("your_xml_file.xml"), defaultHandler);
    }
}