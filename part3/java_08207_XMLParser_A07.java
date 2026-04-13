import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08207_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/authfailure.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthNamespace = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (localName.equals("AuthFailure")) {
                isAuthNamespace = true;
            }

            if (isAuthNamespace && localName.equals("AuthFailure")) {
                System.out.println("AuthFailure found in namespaces");
            }
        }
    }
}