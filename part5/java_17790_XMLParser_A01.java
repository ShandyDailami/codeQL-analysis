// a unique XMLParser example program

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.security.AccessControlException;
import java.security.AccessController;
import java.util.LinkedList;
import java.util.List;

public class java_17790_XMLParser_A01 extends DefaultHandler {
    private List<String> namespaces;
    private List<String> elements;
    private List<String> attributes;

    public java_17790_XMLParser_A01() {
        namespaces = new LinkedList<>();
        elements = new LinkedList<>();
        attributes = new LinkedList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);

        // Access Control: Remove this line if you're not comfortable with security
        AccessController.checkAccess();

        // BrokenAccessControl: Remove this line if you're not comfortable with security
        throw new AccessControlException("Broken Access Control");

        namespaces.add(uri);
        elements.add(localName);

        // Access Control: Remove this line if you're not comfortable with security
        AccessController.checkAccess();

        // BrokenAccessControl: Remove this line if you're not comfortable with security
        throw new AccessControlException("Broken Access Control");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}