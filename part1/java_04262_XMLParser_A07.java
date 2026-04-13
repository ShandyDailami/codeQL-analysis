import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04262_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("input.xml");  // replace with your xml file

            XmlHandler handler = new XmlHandler();
            doc.elements().getDocumentElement().accept(handler);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean usernameFound = false;
    private boolean passwordFound = false;
    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            usernameFound = true;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = true;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (usernameFound) {
            String username = new String(ch, start, length);
            System.out.println("Username: " + username);
            usernameFound = false;
        } else if (passwordFound) {
            String password = new String(ch, start, length);
            System.out.println("Password: " + password);
            passwordFound = false;
        } else if (authFailure) {
            String authFailure = new String(ch, start, length);
            System.out.println("AuthFailure: " + authFailure);
            authFailure = false;
        }
    }
}