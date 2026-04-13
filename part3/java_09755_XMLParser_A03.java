import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_09755_XMLParser_A03 {

    private static List<String> securitySensitiveOperations = new ArrayList<>();

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "    <operation>Select</operation>\n" +
                "    <operation>Insert</operation>\n" +
                "    <operation>Update</operation>\n" +
                "    <operation>Delete</operation>\n" +
                "</root>";

        XmlHandler handler = new XmlHandler();
        try {
            org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = spf.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);

            printSecuritySensitiveOperations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printSecuritySensitiveOperations() {
        if (securitySensitiveOperations.isEmpty()) {
            System.out.println("No security-sensitive operations found");
        } else {
            System.out.println("Security-sensitive operations:");
            securitySensitiveOperations.forEach(System.out::println);
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private boolean operationFound = false;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("operation".equals(localName)) {
                operationFound = true;
                currentElement = qName;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("operation".equals(localName)) {
                if ("Select".equals(currentElement) || "Insert".equals(currentElement)
                        || "Update".equals(currentElement) || "Delete".equals(currentElement)) {
                    securitySensitiveOperations.add(currentElement);
                }
                operationFound = false;
            }
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (operationFound) {
                currentElement += new String(ch, start, length);
            }
        }
    }
}