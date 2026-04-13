import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_08586_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        String maliciousXml = "<malicious-content></malicious-content>";
        byte[] maliciousXmlBytes = maliciousXml.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(maliciousXmlBytes);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        saxParser.parse(inputStream, new MySAXHandler());
    }

    static class MySAXHandler implements SAXHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // This method should not be called, as the XML document is malicious and the SAXParser should not be used for parsing it.
            System.out.println("Malicious XML content detected: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // This method should not be called, as the XML document is malicious and the SAXParser should not be used for parsing it.
            System.out.println("End of malicious XML content: " + localName);
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            // This method should not be called, as the XML document is malicious and the SAXParser should not be used for parsing it.
            System.out.println("Start of malicious XML content: " + prefix);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            // This method should not be called, as the XML document is malicious and the SAXParser should not be used for parsing it.
            System.out.println("End of malicious XML content: " + prefix);
        }
    }
}