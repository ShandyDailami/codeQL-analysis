import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_38354_XMLParser_A01 extends DefaultHandler {

    private List<String> urls = new ArrayList<>();
    private List<String> users = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();

        if (content.isEmpty()) {
            return;
        }

        switch (currentElement) {
            case "url":
                urls.add(content);
                break;
            case "user":
                users.add(content);
                break;
            case "role":
                roles.add(content);
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            parser.parse(xml, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getUrls() {
        return urls;
    }

    public List<String> getUsers() {
        return users;
    }

    public List<String> getRoles() {
        return roles;
    }
}

public class Main {

    public static void main(String[] args) {
        String xml = "<security>" +
                "<url>http://www.google.com</url>" +
                "<user>admin</user>" +
                "<role>admin</role>" +
                "<url>http://www.yahoo.com</url>" +
                "<user>user1</user>" +
                "<role>user</role>" +
                "</security>";

        SecurityHandler handler = new SecurityHandler();
        handler.parse(xml);

        List<String> urls = handler.getUrls();
        List<String> users = handler.getUsers();
        List<String> roles = handler.getRoles();

        for (int i = 0; i < urls.size(); i++) {
            System.out.println("URL: " + urls.get(i));
            System.out.println("User: " + users.get(i));
            System.out.println("Role: " + roles.get(i));
        }
    }
}