import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_05245_XMLParser_A07 {

    public static class MySAXHandler extends DefaultHandler {

        private boolean authFailure = false;
        private boolean authSuccess = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                authFailure = true;
            } else if (qName.equalsIgnoreCase("AuthSuccess")) {
                authSuccess = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (authFailure) {
                System.out.println("AuthFailure detected!");
                authFailure = false;
            } else if (authSuccess) {
                System.out.println("AuthSuccess detected!");
                authSuccess = false;
            }
        }
    }

    public static void main(String[] args) {
        String xml = "<root><AuthFailure /><AuthSuccess /><AuthFailure /></root>";

        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new InputSource(new StringReader(xml)));
            MySAXHandler myHandler = new MySAXHandler();
            saxParser.setContentHandler(myHandler);
            saxParser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}