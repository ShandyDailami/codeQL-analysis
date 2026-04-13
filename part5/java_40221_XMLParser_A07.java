import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_40221_XMLParser_A07 {
    public static void main(String[] args) {
        String url = "http://www.example.com/authfailure.xml"; // replace with your URL
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler handler = new MyHandler();
            saxParser.parse(url, handler);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean authFailure;

    public java_40221_XMLParser_A07() {
        authFailure = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (authFailure) {
            System.out.println("Authentication failure detected");
            authFailure = false;
        }
    }
}