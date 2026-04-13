import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_41553_XMLParser_A07 extends DefaultHandler {
    private List<String> authFailureLogs = new ArrayList<>();
    private String currentElement;

    public List<String> getAuthFailureLogs() {
        return authFailureLogs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("AuthFailure")) {
            authFailureLogs.add(qName);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("AuthFailure")) {
            authFailureLogs.add(new String(ch, start, length));
        }
    }
}

public class XmlParserExample {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            AuthFailureHandler authFailureHandler = new AuthFailureHandler();
            saxParser.parse("src/main/resources/authFailures.xml", authFailureHandler);

            List<String> authFailureLogs = authFailureHandler.getAuthFailureLogs();
            for (String log : authFailureLogs) {
                System.out.println(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}