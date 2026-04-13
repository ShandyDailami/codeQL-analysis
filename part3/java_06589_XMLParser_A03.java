import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06589_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";  // replace with your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean name;
        private boolean url;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                name = true;
            } else if (qName.equals("url")) {
                url = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                name = false;
            } else if (qName.equals("url")) {
                url = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                String value = new String(ch, start, length);
                // Process name here, e.g., print to console
                System.out.println("Name: " + value);
            } else if (url) {
                String value = new String(ch, start, length);
                // Process URL here, e.g., print to console
                System.out.println("URL: " + value);
            }
        }
    }
}