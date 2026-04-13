import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01617_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(XmlParser.class.getResourceAsStream("example.xml"), new SAXSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = true;
                return;
            }

            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
                return;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                return;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                bName = false;
                String name = new String(ch, start, length);
                System.out.println("Name: " + name);
            } else if (bAge) {
                bAge = false;
                String age = new String(ch, start, length);
                System.out.println("Age: " + age);
            }
        }
    }

    static class SAXSettings extends SAXParserFactory.newInstance().getSAXParser().getXMLReader().getFeature("http://xml.org/sax/features/namespaces") {
        @Override
        public boolean getNamespacePrefixInfo(String uri, String lname, Set<? extends String> prefixes) {
            return false;
        }

        @Override
        public void setNamespacePrefixInfo(String uri, String prefix) {
            throw new UnsupportedOperationException();
        }
    }
}