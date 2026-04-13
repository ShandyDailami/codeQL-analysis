import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11124_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your XML file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlFile));
            parser.parse(xmlFile, new XmlHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {

        private static final String ACCESS_CONTROL_POLICY = "AccessControlPolicy";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase(ACCESS_CONTROL_POLICY)) {
                System.out.println("Access control policy found!");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // no action required in this case
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // no action required in this case
        }
    }
}