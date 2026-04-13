import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10983_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/data.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data;
    private boolean person;
    private boolean firstName;
    private boolean lastName;

    @Override
    public void startDocument() throws SAXException {
        data = new StringBuilder();
        person = false;
        firstName = false;
        lastName = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            person = true;
            return;
        }

        if (person) {
            if (qName.equalsIgnoreCase("firstName")) {
                firstName = true;
                return;
            }

            if (qName.equalsIgnoreCase("lastName")) {
                lastName = true;
                return;
            }
        }

        data.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            person = false;
            return;
        }

        if (person) {
            if (qName.equalsIgnoreCase("firstName")) {
                firstName = false;
                return;
            }

            if (qName.equalsIgnoreCase("lastName")) {
                lastName = false;
                return;
            }
        }

        data.append(" ").append(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (firstName) {
            data.append(" - First Name: ").append(new String(ch, start, length));
        } else if (lastName) {
            data.append(" - Last Name: ").append(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        System.out.println(data.toString());
    }
}