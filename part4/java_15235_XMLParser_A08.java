import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_15235_XMLParser_A08 extends DefaultHandler {

    private StringBuilder data;

    public java_15235_XMLParser_A08() {
        data = new StringBuilder();
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler(this));
            parser.parse(fileName, this);
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.append(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    private static class MyXMLHandler extends DefaultHandler {

        private MyXMLParser parser;

        public java_15235_XMLParser_A08(MyXMLParser parser) {
            this.parser = parser;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            parser.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            parser.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            parser.characters(ch, start, length);
        }
    }
}