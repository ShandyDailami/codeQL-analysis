import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_15620_XMLParser_A07 {

    public static class MySAXHandler extends DefaultHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }

    }

    public static void main(String[] args) {
        String xml = "<doc><hello>world!</hello></doc>";
        parse(xml);
    }

    private static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            MySAXHandler handler = new MySAXHandler();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}