import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_02544_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Creating a SAXParser instance

            InputStream inputStream = XMLParser.class.getClassLoader().getResourceAsStream("sample.xml"); // Loading the XML file

            saxParser.parse(inputStream, new MyHandler()); // Parsing the XML
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // This is the SAX handler that processes the XML
    private static class MyHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;
        private boolean isDescription = false;

        private String title;
        private String link;
        private String description;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            } else if (qName.equalsIgnoreCase("description")) {
                isDescription = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = false;
            } else if (qName.equalsIgnoreCase("description")) {
                isDescription = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                title = new String(ch, start, length);
            } else if (isLink) {
                link = new String(ch, start, length);
            } else if (isDescription) {
                description = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Title: " + title);
            System.out.println("Link: " + link);
            System.out.println("Description: " + description);
        }
    }
}