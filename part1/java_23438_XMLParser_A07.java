import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_23438_XMLParser_A07 extends DefaultHandler {

    private boolean isUser = false;
    private boolean isPassword = false;
    private boolean isAuth = false;
    private List<String> authFailures = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("auth")) {
            isAuth = true;
        } else if (qName.equalsIgnoreCase("user")) {
            isUser = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("auth")) {
            isAuth = false;
        } else if (qName.equalsIgnoreCase("user")) {
            isUser = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUser) {
            String user = new String(ch, start, length);
            // add user to the security layer here
            System.out.println("User: " + user);
        } else if (isPassword) {
            String password = new String(ch, start, length);
            // add password to the security layer here
            System.out.println("Password: " + password);
        } else if (isAuth) {
            String authFailure = new String(ch, start, length);
            authFailures.add(authFailure);
            // add auth failure to a list here
            System.out.println("Auth Failure: " + authFailure);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Auth Failures:");
        for (String failure : authFailures) {
            System.out.println(failure);
        }
    }
}