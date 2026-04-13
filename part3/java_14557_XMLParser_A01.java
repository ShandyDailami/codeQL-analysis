import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_14557_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age></person>";
        parseXML(xml);
    }

    public static void parseXML(String xml) {
        // Create a new SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            // Parse the XML data and don't need to call the load() method
            parser.parse(new InputSource(new StringReader(xml)), false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // DefaultHandler is the default behaviour of SAX parser
    public static class MyHandler extends DefaultHandler {

        // Override startElement method
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        // Override endElement method
        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        // Override characters method
        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}