import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_00291_XMLParser_A07 extends DefaultHandler {
    private static final String ROOT = "A07_AuthFailure";

    private boolean isRootElement = false;
    private boolean isAuthElement = false;
    private boolean isFailureElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(ROOT)) {
            isRootElement = true;
        } else if (qName.equals("Auth")) {
            isAuthElement = true;
        } else if (qName.equals("Failure")) {
            isFailureElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(ROOT) && isRootElement) {
            System.out.println("Root element found");
        } else if (qName.equals("Auth") && isAuthElement) {
            System.out.println("Auth element found");
            isAuthElement = false;
        } else if (qName.equals("Failure") && isFailureElement) {
            System.out.println("Failure element found");
            isFailureElement = false;
        }
    }

    public static void main(String[] args) {
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<A07_AuthFailure>" +
                "<Auth>Auth data</Auth>" +
                "<Failure>Failure data</Failure>" +
                "</A07_AuthFailure>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new CustomXMLParser());
            parser.parse(new InputSource(new StringReader(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}