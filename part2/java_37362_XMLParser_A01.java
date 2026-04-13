import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_37362_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Create a SAX parser
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;
        private String currentElement;

        @Override
        public void startDocument() {
            stringBuilder = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println(stringBuilder.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            stringBuilder.append("Start element: " + qName + "\n");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentElement = null;
            stringBuilder.append("End element: " + qName + "\n");
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (currentElement != null) {
                stringBuilder.append(new String(ch, start, length));
            }
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}