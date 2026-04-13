import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_12411_XMLParser_A07 {
    public static void main(String[] args) {
        XMLReader reader = SAXParser.newInstance().createXMLReader();
        reader.setContentHandler(new MyContentHandler());

        try {
            reader.parse("input.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Handle start element here
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Handle end element here
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Handle character data here
        }

        @Override
        public void error(SAXException e) {
            // Handle SAX exception here
        }
    }
}