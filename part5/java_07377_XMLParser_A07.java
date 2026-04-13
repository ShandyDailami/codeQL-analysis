import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07377_XMLParser_A07 {

    public static void main(String[] args) {
        String file = "example.xml";

        // Create SAX Parser Factory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            // Create SAX Parser
            SAXParser saxParser = spf.newSAXParser();

            // Create a new handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            saxParser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create a default handler that will be used for parsing the XML file
    public static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
        private String tempValue;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
            if (qName.equals("name")) {
                bName = true;
            }
            if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            }
            if (qName.equals("name")) {
                bName = false;
            }
            if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                tempValue = new String(ch, start, length);
                System.out.println("Name: " + tempValue);
                bName = false;
            }
            if (bAge) {
                tempValue = new String(ch, start, length);
                System.out.println("Age: " + tempValue);
                bAge = false;
            }
        }

    }
}