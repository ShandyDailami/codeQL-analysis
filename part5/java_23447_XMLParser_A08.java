import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23447_XMLParser_A08 {

    private static final String XML_FILE_PATH = "path_to_your_xml_file"; // Replace with your xml file path

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new File(XML_FILE_PATH), handler);
    }

    private static class MyHandler extends DefaultHandler {
        private boolean elementName = false;
        private boolean elementValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                elementName = true;
                elementValue = false;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (elementName) {
                elementName = false;
                System.out.println("Element Name: " + new String(chars, start, length));
            } else if (elementValue) {
                elementValue = false;
                System.out.println("Element Value: " + new String(chars, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                elementName = false;
                elementValue = false;
            }
        }
    }
}