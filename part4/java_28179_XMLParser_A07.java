import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_28179_XMLParser_A07 extends DefaultHandler {
    private boolean isUsername = false;
    private boolean isPassword = false;
    private String currentElement = "";
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("user")) {
            isUsername = true;
            isPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (isUsername) {
            usernames.add(content);
            isUsername = false;
        } else if (isPassword) {
            passwords.add(content);
            isPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            // handle user data
            for (String username : usernames) {
                System.out.println("Username: " + username);
            }
            for (String password : passwords) {
                System.out.println("Password: " + password);
            }
            usernames.clear();
            passwords.clear();
        }
    }
}