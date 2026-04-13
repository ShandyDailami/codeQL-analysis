import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReader.UncaughtExceptionHandler;

public class java_40633_XMLParser_A01 {

    public static void parse(String xml, XSSHandler handler) {
        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                handler.startElement(uri, localName, qName, attributes);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                handler.endElement(uri, localName, qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                String content = new String(ch, start, length);
                handler.characters(content);
            }
        };

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser(null, defaultHandler,
                    new XMLErrorHandler()).getXMLReader();

            reader.setContentHandler(defaultHandler);
            reader.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<root><content>" +
                "<script>alert('XSS Attack');</script>" +
                "</content></root>";
        XSSAttackPreventionSAXParser.parse(xml, new XSSHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + localName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + localName);
            }

            @Override
            public void characters(String content) {
                System.out.println("Content: " + content);
            }
        });
    }

    interface XSSHandler {
        void startElement(String uri, String localName, String qName, Attributes attributes);
        void endElement(String uri, String localName, String qName);
        void characters(String content);
    }
}