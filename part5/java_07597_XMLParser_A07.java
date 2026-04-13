import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07597_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            parser.parse(LegacyXmlParser.class.getResourceAsStream("/example.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private int depth = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(new String(ch, start, length));
        }
    }
}