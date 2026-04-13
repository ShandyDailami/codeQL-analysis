import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_34501_XMLParser_A01 {
    private List<String> securitySensitiveOperations = new ArrayList<>();

    public void parse(String file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler(securitySensitiveOperations));
            parser.parse(file, new SAXSource(new File(file)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getSecuritySensitiveOperations() {
        return securitySensitiveOperations;
    }

    private static class MyHandler extends DefaultHandler {
        private List<String> securitySensitiveOperations;
        private StringBuilder data;
        private String currentElement;

        public java_34501_XMLParser_A01(List<String> securitySensitiveOperations) {
            this.securitySensitiveOperations = securitySensitiveOperations;
        }

        @Override
        public void startDocument() throws SAXException {
            data = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("operation")) {
                securitySensitiveOperations.add(data.toString());
            }
            currentElement = "";
            data = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Security-sensitive operations: " + securitySensitiveOperations);
        }
    }
}