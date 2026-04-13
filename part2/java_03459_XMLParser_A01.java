import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03459_XMLParser_A01 {

    // SAX Parse the XML document
    public void parse(String file) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            // Create the Handler
            MyHandler handler = new MyHandler();

            // Parse the XML
            sp.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler
    private class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }

            if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
            }

            if (bName && qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            }

            if (bAge) {
                age = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name + ", Age: " + age);
                bName = false;
                bAge = false;
                name = null;
                age = null;
            }
        }
    }

    public static void main(String args[]) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
    }
}