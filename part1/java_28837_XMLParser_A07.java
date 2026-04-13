import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_28837_XMLParser_A07 extends DefaultHandler {

    private List<String> failedLogins = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("login")) {
            String login = attributes.getValue("name");
            failedLogins.add(login);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("login")) {
            // Here you would typically do some security-sensitive operation
            // like sending an email or logging the failure
        }
    }

    public List<String> getFailedLogins() {
        return failedLogins;
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<logins><login name='user1'></login><login name='user2'></login><login name='user3'></login></logins>";
        AuthFailureHandler handler = new AuthFailureHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));

            List<String> failedLogins = handler.getFailedLogins();
            for (String login : failedLogins) {
                System.out.println("Login failed: " + login);
            }

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}