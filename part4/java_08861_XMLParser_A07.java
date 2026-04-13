import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_08861_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        private boolean isInElement = false;
        private String currentElement = null;
        private List<String> errors = null;

        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            isInElement = true;
            currentElement = qName;
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            isInElement = false;
            currentElement = null;
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (isInElement) {
                String elementContent = new String(ch, start, length);
                if (elementContent.trim().length() == 0) {
                    return;
                }
                if (errors != null) {
                    errors.add(elementContent);
                }
            }
        }

        public void startDocument() throws SAXException {
            errors = null;
        }

        public void endDocument() throws SAXException {
            if (errors != null && !errors.isEmpty()) {
                for (String error : errors) {
                    System.out.println("ERROR: " + error);
                }
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/authFailures.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}