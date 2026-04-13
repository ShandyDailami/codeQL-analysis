import java.io.*;
import java.net.URL;
import java.util.List;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30115_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse("http://example.com/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parse(String url) throws Exception {
        URL u = new URL(url);
        InputStream in = u.openStream();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(in));

        Handler h = new Handler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // Implement your security-sensitive operations here
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                // Implement your security-sensitive operations here
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                // Implement your security-sensitive operations here
            }
        };
        parser.setContentHandler(h);
        parser.parse(new InputSource(in));
    }

    class Handler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Implement your security-sensitive operations here
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Implement your security-sensitive operations here
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Implement your security-sensitive operations here
        }
    }
}