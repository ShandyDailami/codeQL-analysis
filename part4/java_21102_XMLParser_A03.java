import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_21102_XMLParser_A03 extends DefaultHandler {

    private List<String> securitySensitiveOperations;

    public java_21102_XMLParser_A03() {
        this.securitySensitiveOperations = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("operation")) {
            String operation = attributes.getValue("name");
            securitySensitiveOperations.add(operation);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do here
    }

    public List<String> getSecuritySensitiveOperations() {
        return securitySensitiveOperations;
    }
}

public class Main {

    public static void main(String[] args) {
        SecuritySAXParser saxParser = new SecuritySAXParser();

        // Assuming this is a method that fetches the XML data
        String xmlData = fetchXMLData();

        // Parse the XML data using the SAX parser
        org.xml.sax.XMLReader reader = org.xml.sax.XMLReaderFactory.createXMLReader();
        reader.setContentHandler(saxParser);
        reader.parse(new StringReader(xmlData));

        // Get the list of security sensitive operations
        List<String> securitySensitiveOperations = saxParser.getSecuritySensitiveOperations();

        // Do something with the security sensitive operations
        for (String operation : securitySensitiveOperations) {
            // Do something with operation
        }
    }

    private static String fetchXMLData() {
        // Implement this method to fetch the XML data
        // Assuming this method returns a simple XML string
        return "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "    <operation name=\"Injection\"/>\n" +
                "    <operation name=\"Denial of Service\"/>\n" +
                "</root>";
    }
}