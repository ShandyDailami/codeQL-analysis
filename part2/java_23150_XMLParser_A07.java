import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23150_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("input.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean authFailureFound = false;
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("authFailure")) {
                authFailureFound = true;
                sb.append("AuthFailure found: " + attributes.getValue(""));
            }
            sb.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                sb.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
            sb.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            sb.append("</").append(qName).append(">");
            if (authFailureFound) {
                System.out.println(sb.toString());
                authFailureFound = false;
                sb.setLength(0);
            }
        }
    }
}