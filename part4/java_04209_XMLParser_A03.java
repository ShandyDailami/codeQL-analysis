import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_04209_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<document><name>John Doe</name><city>New York</city></document>";
        parse(xml);
    }

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            saxParser.parse(new StringReader(xml), new MyHandler());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }
}