import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_34032_XMLParser_A01 extends DefaultHandler {
    private List<User> users = new ArrayList<>();
    private User currentUser;
    private String currentElement;

    public static class User {
        public String id;
        public String name;
        public String password;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            currentUser = new User();
            currentUser.id = attributes.getValue("id");
        } else if (qName.equals("name")) {
            currentElement = "name";
        } else if (qName.equals("password")) {
            currentElement = "password";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("name")) {
            currentUser.name = new String(ch, start, length);
        } else if (currentElement.equals("password")) {
            currentUser.password = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("user")) {
            users.add(currentUser);
        }
    }

    public void parse(String xml) {
        // Parse XML using SAX
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            SensitiveDataHandler handler = new SensitiveDataHandler();
            saxParser.parse(xml, handler);

            // Print sensitive data
            for (User user : handler.users) {
                System.out.println("ID: " + user.id);
                System.out.println("Name: " + user.name);
                System.out.println("Password: " + user.password);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<doc><user id=\"123\"><name>John Doe</name><password>Secret123</password></user><user id=\"456\"><name>Jane Doe</name><password>Secret456</password></user></doc>";
        new SensitiveDataHandler().parse(xml);
    }
}