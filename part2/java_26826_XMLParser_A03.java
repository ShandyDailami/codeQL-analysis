import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_26826_XMLParser_A03 {
    private DefaultHandler handler;

    public java_26826_XMLParser_A03() {
        handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start of XML document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End of XML document");
            }

            @Override
            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start of element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String str = new String(ch, start, length);
                System.out.println("Character data: " + str);
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start of prefix mapping: " + prefix + " - " + uri);
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End of prefix mapping: " + prefix);
            }
        };
    }

    public void parse(String file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new XMLParser().parse("sample.xml");
    }
}