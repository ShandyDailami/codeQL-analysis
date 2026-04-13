import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.MalformedURLException;
import java.util.List;

public class java_13503_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        String url = "http://example.com/sax.xml";  // replace with your XML document url

        try {
            saxParser.parse(url, new XMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler implements javax.xml.parsers.SAXHandler {

        private List<String> tags;

        public java_13503_XMLParser_A03() {
            tags = null;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
            tags = null;  // reset tags list
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws javax.xml.parsers.SAXException {
            if (tags != null) {
                // Security sensitive operation: check if tag list contains a known injection point
                if (tags.contains("injectionPoint")) {
                    System.out.println("Injection detected!");
                }
                tags = null;  // reset tags list
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws javax.xml.parsers.SAXException {
            if (tags != null) {
                // Security sensitive operation: check if character array contains a known injection point
                String injectionPoint = new String(ch, start, length);
                if (injectionPoint.contains("injectionPoint")) {
                    System.out.println("Injection detected!");
                }
            }
        }
    }
}