import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22913_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(XmlSAXParser.class.getResourceAsStream("test.xml"), new SAXSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        private String lastElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastElement = null;
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                String content = new String(ch, start, length);
                System.out.println("Element content: " + content);
            }
        }
    }

    static class SAXSettings extends SAXParserFactory.NewSAXParser() {
        @Override
        public SAXParser getParser() throws Exception {
            return new SAXParserImpl();
        }
    }

    static class SAXParserImpl extends SAXParserBaseImpl {
        @Override
        public void parse(InputStream in, SAXHandler handler) throws ParseException {
            SAXSourceImpl source = new SAXSourceImpl(in);
            handler.startDocument();
            try {
                while (true) {
                    int event = source.getEventType();
                    String name = source.getLocalName();
                    if (event == END_DOCUMENT) {
                        break;
                    } else {
                        handler.startElement(null, name, name, null);
                        while (true) {
                            event = source.getEventType();
                            if (event == END_DOCUMENT) {
                                break;
                            } else {
                                name = source.getLocalName();
                                handler.characters(source.getChars(), source.getStartPosition(), source.getLength());
                            }
                        }
                        handler.endElement(null, name, name);
                    }
                }
            } finally {
                handler.endDocument();
            }
        }
    }
}