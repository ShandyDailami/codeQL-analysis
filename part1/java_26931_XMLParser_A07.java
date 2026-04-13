import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_26931_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";
    private User currentUser = null;
    private List<User> userList = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("user")) {
            currentUser = new User();
            userList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("user") && currentUser != null) {
            currentUser.setName(attributes.getValue("name"));
            currentUser.setAge(Integer.parseInt(attributes.getValue("age")));
            userList.add(currentUser);
            currentUser = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (qName.equalsIgnoreCase("user")) {
            if (currentUser != null) {
                userList.add(currentUser);
            }
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && currentElement.equalsIgnoreCase("name")) {
            currentUser.setName(new String(ch, start, length));
            bName = true;
        } else if (currentElement != null && currentElement.equalsIgnoreCase("age")) {
            currentUser.setAge(Integer.parseInt(new String(ch, start, length)));
            bAge = true;
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("test.xml").getResourceAsStream("test.xml"), handler);
            for (User user : handler.getUserList()) {
                System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public class User {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}