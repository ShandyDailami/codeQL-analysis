import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_18847_XMLParser_A08 extends DefaultHandler {

    private boolean bName;
    private boolean bId;
    private boolean bRole;
    private List<User> users = new ArrayList<>();
    private User currentUser;

    @Override
    public void startDocument() throws SAXException {
        bName = bId = bRole = true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            currentUser = new User();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("id")) {
            bId = false;
        } else if (qName.equalsIgnoreCase("role")) {
            bRole = false;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (bName) {
            currentUser.setName(new String(chars, start, length));
        } else if (bId) {
            currentUser.setId(new String(chars, start, length));
        } else if (bRole) {
            currentUser.setRole(new String(chars, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            users.add(currentUser);
        }
    }

    public List<User> getUsers() {
        return users;
    }
}

class User {
    private String name;
    private String id;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}