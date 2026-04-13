import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sarsaw.SAXParser;
import org.xml.sarsaw.SAXParserFactory;

public class java_27354_XMLParser_A07 {

    private static class SecureHandler extends DefaultHandler {

        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            data.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            data.append(ch, start, length);
        }

        public String getData() {
            return data.toString();
        }
    }

    public static String parseSecureXML(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SecureHandler handler = new SecureHandler();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(filePath);
            return handler.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String sensitiveData = parseSecureXML("path_to_your_secure_xml_file");
        // use sensitiveData securely
    }
}