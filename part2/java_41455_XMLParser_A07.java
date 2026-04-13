import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_41455_XMLParser_A07 extends DefaultHandler {
    private List<String> authFailures = new ArrayList<>();
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement.equals("AuthFailure")) {
            authFailures.add(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = "";
    }

    public List<String> getAuthFailures() {
        return authFailures;
    }
}

public class XMLParser {
    public static void main(String[] args) {
        String xml = "<root>\n" +
                "<A07_AuthFailure>\n" +
                "<AuthFailure>false</AuthFailure>\n" +
                "</A07_AuthFailure>\n" +
                "<A07_AuthFailure>\n" +
                "<AuthFailure>true</AuthFailure>\n" +
                "</A07_AuthFailure>\n" +
                "</root>";

        AuthFailureHandler handler = new AuthFailureHandler();
        SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(xml)), handler);

        List<String> authFailures = handler.getAuthFailures();
        for (String failure : authFailures) {
            System.out.println("AuthFailure: " + failure);
        }
    }
}