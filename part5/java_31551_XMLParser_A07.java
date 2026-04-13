import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31551_XMLParser_A07 extends DefaultHandler {
    private String lastElement;
    private StringBuilder currentElementContent;
    private boolean usernameInput = false;
    private boolean passwordInput = false;
    private String username;
    private String password;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        currentElementContent = new StringBuilder();
        if (qName.equals("authenticate")) {
            usernameInput = true;
            passwordInput = true;
        } else {
            if (lastElement.equals("username") && usernameInput) {
                usernameInput = false;
            } else if (lastElement.equals("password") && passwordInput) {
                passwordInput = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastElement)) {
            if (lastElement.equals("authenticate")) {
                if (username != null && password != null) {
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                } else {
                    System.out.println("Invalid username or password");
                }
            }
            lastElement = null;
            currentElementContent = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equals("authenticate")) {
            currentElementContent.append(ch, start, length);
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        try {
            parser.parse(Class.forName("yourXMLFile").getResourceAsStream("yourXMLFile"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}