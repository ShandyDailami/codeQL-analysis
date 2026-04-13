import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_39908_XMLParser_A01 {
    public static class MyHandler extends DefaultHandler {
        boolean bElement = false;
        String elementValue = null;

        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            bElement = true;
            elementValue = "";
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bElement = false;
            System.out.println(qName + " = " + elementValue);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bElement) {
                elementValue = new String(ch, start, length);
            }
        }
    }

    public static void parse(String fileName) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

        saxParser.parse(fileName, MyHandler.class);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        parse("input.xml");
    }
}