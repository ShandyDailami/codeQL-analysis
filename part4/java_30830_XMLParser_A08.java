import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_30830_XMLParser_A08 {
    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";
    private List<String> integrityFailures = new ArrayList<>();

    public void parse(String filename) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        sp.parse(filename, mh);

        // Print out the integrity failures
        for (String failure : integrityFailures) {
            System.out.println(failure);
        }
    }

    private class MyHandler extends DefaultHandler {
        private String lastElement = null;
        private boolean foundIntegrityFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("User")) {
                lastElement = qName;
            } else if (qName.equals("Password") && lastElement.equals("User")) {
                foundIntegrityFailure = true;
                integrityFailures.add("Password element found in User element");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("User")) {
                lastElement = null;
            }
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, SAXException {
        XmlParser parser = new XmlParser();
        parser.parse("users.xml");
    }
}