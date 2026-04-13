import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08595_XMLParser_A08 extends DefaultHandler {

    private Key key;
    private Mac mac;

    public java_08595_XMLParser_A08(String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        this.key = new SecretKeySpec(secret.getBytes(), "HmacMD5");
        this.mac = Mac.getInstance(this.key.getAlgorithm());
        this.mac.init(this.key);
    }

    public void parse(String file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        parser.setContentHandler(this);
        parser.parse(new File(file));
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        // TODO: Handle start element.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO: Handle end element.
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        // TODO: Handle characters.
        String str = new String(chars, start, length);
        // TODO: Check integrity of str.
        byte[] bytes = str.getBytes();
        byte[] macBytes = this.mac.doFinal(bytes);
        // TODO: Check integrity of macBytes.
    }
}