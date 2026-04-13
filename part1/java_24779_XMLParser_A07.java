import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_24779_XMLParser_A07 extends DefaultHandler {
    private boolean isName = false;
    private boolean isAge = false;
    private boolean isEmail = false;
    private String name = null;
    private String age = null;
    private String email = null;

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyXMLParser handler = new MyXMLParser();
        parser.parse(new File("src/sample.xml"), handler);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            return;
        }

        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("age")) {
            isAge = true;
        } else if (qName.equals("email")) {
            isEmail = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("age")) {
            isAge = false;
        } else if (qName.equals("email")) {
            isEmail = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name = new String(ch, start, length);
        } else if (isAge) {
            age = new String(ch, start, length);
        } else if (isEmail) {
            email = new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}