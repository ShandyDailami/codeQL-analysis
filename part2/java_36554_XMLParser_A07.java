import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36554_XMLParser_A07 extends DefaultHandler {
    private boolean isAuthFailure = false;
    private StringBuffer buffer = new StringBuffer();

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAuthFailure) {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                System.out.println("AuthFailure detected: " + buffer.toString());
                isAuthFailure = false;
            }
        } else {
            buffer.append(qName);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) {
        String xml = "<root><AuthFailure>Security failure</AuthFailure></root>";
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}