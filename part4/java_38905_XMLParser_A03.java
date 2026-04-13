import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_38905_XMLParser_A03 {

    public static void parseFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Create SAX parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.setContentHandler(myHandler);

        // Parse the file
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            saxParser.parse(file, xmlReader);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseFile("test.xml");
    }

    private static class MyHandler extends DefaultHandler {

        private StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            sb.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            sb.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String content = sb.toString();
            // Perform security sensitive operation here, e.g. perform injection
            performInjection(content);
        }

        private void performInjection(String content) {
            // No injection here, this is just an example
            System.out.println("Injection: " + content);
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAX warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("SAX error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("SAX fatal error: " + e.getMessage());
        }
    }
}