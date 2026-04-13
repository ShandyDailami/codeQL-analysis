import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.Cipher;
import javax.crypto.CipherInputStream;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class java_32337_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(Paths.get("example.xml"), new DefaultHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;
    private String name;
    private int age;
    private String country;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.NamespaceContext namespaceContext)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // This is the start of a person
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        } else if (bCountry) {
            country = new String(ch, start, length);
        }
    }
}