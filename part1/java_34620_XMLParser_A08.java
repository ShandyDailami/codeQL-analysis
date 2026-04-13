import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_34620_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        public void warning(SAXWarning warning) throws SAXException {
            System.out.println("Warning: " + warning.getMessage());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "example.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        parser.parse(xmlFile, MyHandler.class);
    }
}