import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_34403_XMLParser_A01 {
    public static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start Document");
        }

        public void endDocument() {
            System.out.println("End Document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + localName);
        }

        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String input = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        parser.parse(new InputSource(new StringReader(input)));
    }
}