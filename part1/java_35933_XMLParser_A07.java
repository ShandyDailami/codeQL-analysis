import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_35933_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true); // use SAXParser for readability
            saxParser.parse(new InputSource(xmlFile), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for SAX events
    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}