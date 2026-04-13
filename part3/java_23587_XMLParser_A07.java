import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_23587_XMLParser_A07 extends DefaultHandler {
    private boolean bUser;
    private String currentElement;
    private List<String> userList;

    public java_23587_XMLParser_A07() {
        userList = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        currentElement = qName;
        if (currentElement.equalsIgnoreCase("user")) {
            bUser = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equalsIgnoreCase("user")) {
            bUser = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUser) {
            String user = new String(ch, start, length).trim();
            if (!user.isEmpty()) {
                userList.add(user);
            }
        }
    }

    public List<String> getUserList() {
        return userList;
    }
}