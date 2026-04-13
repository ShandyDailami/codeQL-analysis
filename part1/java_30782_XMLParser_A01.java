import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_30782_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a SAXParser factory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Create a SAXParser
            SAXParser saxParser = factory.newSAXParser();

            // Create an XML file
            File file = new File("example.xml");

            // Create an event handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
        System.out.println("Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Do nothing
    }
}