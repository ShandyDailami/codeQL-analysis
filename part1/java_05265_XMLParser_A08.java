import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05265_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(XmlParser.class.getResourceAsStream("sample.xml"), new SAXParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String lastTag;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            lastTag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastTag.equals("employee")) {
                System.out.println("Found an employee element with name and id");
            }
        }
    }
}