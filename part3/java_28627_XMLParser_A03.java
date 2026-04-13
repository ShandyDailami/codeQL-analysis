import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28627_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "your_xml_file.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            // create a new handler
            MyHandler myHandler = new MyHandler();

            // parse the xml file
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DefaultHandler
    private static class MyHandler extends DefaultHandler {
        private boolean name = false;
        private boolean value = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                name = true;
            }
            if (qName.equalsIgnoreCase("value")) {
                value = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (name) {
                System.out.print("Name: ");
                name = false;
            }
            if (value) {
                System.out.println("Value: " + new String(ch, start, length));
                value = false;
            }
        }
    }
}