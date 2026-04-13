import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXEvent;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00505_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = spf.newSAXParser(null);

            saxParser.parse(Class.forName("yourXMLFile").getResourceAsStream(),
                    new DefaultHandler() {
                        @Override
                        public void startElement(String uri, String localName, String qName, Attributes attributes)
                                throws SAXException {
                            // This method will be called for every start tag
                            // Use it for security sensitive operations
                        }

                        @Override
                        public void endElement(String uri, String localName, String qName)
                                throws SAXException {
                            // This method will be called for every end tag
                            // Use it for security sensitive operations
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}