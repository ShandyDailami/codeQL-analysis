import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_11385_XMLParser_A07 extends DefaultHandler {
    private boolean isName = false;
    private boolean isPassword = false;
    private String currentElement = "";
    private List<User> users = new ArrayList<>();

    public class User {
        String name;
        String password;

        public java_11385_XMLParser_A07(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("user")) {
            isName = true;
            isPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("user")) {
            isName = false;
            isPassword = false;
        } else if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("password")) {
            isPassword = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            String value = new String(ch, start, length);
            if (currentElement.equals("name")) {
                User user = new User(value, "");
                users.add(user);
            }
        } else if (isPassword) {
            String value = new String(ch, start, length);
            for (User user : users) {
                if (user.name.equals(currentElement)) {
                    user.password = value;
                }
            }
        }
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        super.warning(e);
    }

    @Override
    public void error(SAXException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        super.fatalError(e);
    }
}