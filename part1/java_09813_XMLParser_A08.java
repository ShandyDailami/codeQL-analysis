import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09813_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private StringBuilder buffer = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            buffer.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            checkIntegrity(buffer.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                buffer.append(ch, start, length);
            }
        }

        private void checkIntegrity(String data) {
            // Place your security-sensitive operations here
            // For instance, check if the data contains a certain password,
            // and if it does, throw an exception.

            // This is a placeholder, you can replace with your own code.
            if (data.contains("password")) {
                throw new SecurityException("Password found in data. Access is restricted.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
    }
}