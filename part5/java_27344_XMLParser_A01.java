import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_27344_XMLParser_A01 extends DefaultHandler {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start of person: " + localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person: " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (names.size() % 2 == 0) {
            String value = new String(ch, start, length);
            names.add(value);
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();

        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(false);

            saxParser.parse("src/main/resources/persons.xml", handler);

            List<String> names = handler.getNames();
            for (int i = 0; i < names.size(); i += 2) {
                System.out.println("Name: " + names.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}