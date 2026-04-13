import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_38587_XMLParser_A07 extends DefaultHandler {

    private boolean bUsername = false;
    private boolean bPassword = false;
    private String currentElement = "";
    private List<User> users = new ArrayList<>();

    public class User {
        String username;
        String password;

        public java_38587_XMLParser_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("user")) {
            bUsername = true;
            bPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            String user = new String(ch, start, length);
            User newUser = new User(user, "");
            users.add(newUser);
            bUsername = false;
        } else if (bPassword) {
            String password = new String(ch, start, length);
            User newUser = new User("", password);
            users.add(newUser);
            bPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("user")) {
            System.out.println(users.get(users.size() - 1));
            users.clear();
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<root>\n" +
                "    <user>John</user>\n" +
                "    <user>Paul</user>\n" +
                "</root>";
        MyXMLParser parser = new MyXMLParser();
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}