import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_05460_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;
    private boolean bUsername = false;
    private boolean bPassword = false;
    private boolean bError = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        } else if (qName.equalsIgnoreCase("error")) {
            bError = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bUsername && bPassword && bAuthFailure && bError) {
            System.out.println("AuthFailure found in XML.");
            bUsername = bPassword = bAuthFailure = bError = false;
        }
    }

    public static void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("example.xml");
    }
}