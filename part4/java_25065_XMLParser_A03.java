import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_25065_XMLParser_A03 extends DefaultHandler {
    private boolean isName = false;
    private boolean isId = false;
    private String id = null;
    private String name = null;
    private List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        String xml = "<persons>\n" +
                "  <person>\n" +
                "    <id>1</id>\n" +
                "    <name>John Doe</name>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <id>2</id>\n" +
                "    <name>Jane Doe</name>\n" +
                "  </person>\n" +
                "</persons>";

        XMLParser parser = new XMLParser();
        parser.parse(new StringReader(xml));

        for (Person person : parser.getPersons()) {
            System.out.println(person);
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            persons.add(new Person());
        } else if (qName.equalsIgnoreCase("id")) {
            isId = true;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isId = false;
            isName = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isId) {
            id = new String(ch, start, length);
        } else if (isName) {
            name = new String(ch, start, length);
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}

class Person {
    String id, name;

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}