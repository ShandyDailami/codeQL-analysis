import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08803_XMLParser_A03 {

    // SAX parser
    public static void parseXMLUsingSAX(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        try {
            parser.parse(file, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAX event handler
    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String qName = "";
        private int qLine = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = localName;
            bName = true;
            bAge = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            qName = localName;
            if (qName.equals("name")) bName = false;
            if (qName.equals("age")) bAge = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Use the data here
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                // Use the data here
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {
        String file = "src/main/resources/employees.xml";
        parseXMLUsingSAX(file);
    }
}