import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_33953_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            String name = attributes.getValue("name");
            if (name != null && name.matches("^[a-zA-Z0-9]*$")) {
                names.add(name);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do in this case
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do in this case
    }

    public List<String> getNames() {
        return names;
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        try {
            parser.parse("src/main/resources/people.xml", true);
            List<String> names = parser.getNames();
            for (String name : names) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}