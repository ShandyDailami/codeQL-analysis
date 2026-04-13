import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_35220_XMLParser_A07 extends DefaultHandler {

    private boolean authenticationFailed = false;

    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        System.out.println("Data in Element: " + data);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start of PrefixMapping: " + prefix);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End of PrefixMapping: " + prefix);
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
        authenticationFailed = true;
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
        authenticationFailed = true;
    }

    public boolean isAuthenticationFailed() {
        return authenticationFailed;
    }
}

public class MyXMLParser {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        MySAXHandler handler = new MySAXHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        try {
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        if (handler.isAuthenticationFailed()) {
            System.out.println("Authentication Failed");
        }
    }
}