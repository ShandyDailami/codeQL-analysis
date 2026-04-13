import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34795_XMLParser_A03 {
    private String lastElement;
    private String lastText;

    private class ContentHandler extends DefaultHandler {
        private static final String AUTHENTICATION = "authentication";
        private static final String ENCRYPTION = "encryption";
        private static final String COMMUNICATION = "communication";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(AUTHENTICATION) || qName.equals(ENCRYPTION) || qName.equals(COMMUNICATION)) {
                lastElement = qName;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                lastText = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastElement)) {
                handleOperation(lastElement, lastText);
                lastElement = null;
            }
        }
    }

    private void handleOperation(String operation, String text) {
        // Add your security-sensitive operation code here
        // This is a placeholder for the operation
        System.out.println("Performing " + operation + " with text: " + text);
    }

    public void parseFile(String fileName) throws IOException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        ContentHandler contentHandler = new ContentHandler();
        saxParser.parse(new File(fileName), contentHandler);
    }
}