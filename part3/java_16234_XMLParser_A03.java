import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16234_XMLParser_A03 extends DefaultHandler {

    private static final String SAX_INJECTION_POINT = "<injection_point>";
    private static final String SAX_END = "</injection_point>";

    private boolean injectionPointFound = false;
    private StringBuilder injectionPointContent = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals(SAX_INJECTION_POINT)) {
            injectionPointFound = true;
            injectionPointContent.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (injectionPointFound) {
            injectionPointContent.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals(SAX_INJECTION_POINT)) {
            // Check for injection point content
            if (injectionPointContent.length() > 0 && injectionPointContent.toString().contains("<script>")) {
                System.out.println("Detected injection point: " + injectionPointContent.toString());
            }
            // Reset for the next injection point
            injectionPointFound = false;
            injectionPointContent.setLength(0);
        }
    }
}

public class XMLParserExample {
    public static void main(String[] args) {
        String xml = "<data><injection_point>Test <script>alert('Injection point detected!');</script></injection_point>Test</data>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new SecurityInjectionSAXHandler());
            saxParser.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}