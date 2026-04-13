import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_28470_XMLParser_A08 extends DefaultHandler {

    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAddress = false;
    private Person person = null;
    private List<Person> persons = null;

    public java_28470_XMLParser_A08() {
        persons = new ArrayList<>();
    }

    public static void main(String[] args) {
        SAXParserExample saxParser = new SAXParserExample();
        saxParser.parse("src/main/resources/people.xml");
    }

    public void parse(String file) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        try {
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println(persons);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            person = new Person();
            isPerson = true;
            isName = false;
            isAddress = false;
        }
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        }
        if (qName.equalsIgnoreCase("address")) {
            isAddress = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            persons.add(person);
            person = null;
            isPerson = false;
            isName = false;
            isAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPerson) {
            person.setName(new String(ch, start, length));
        }
        if (isName) {
            person.setName(new String(ch, start, length));
        }
        if (isAddress) {
            person.setAddress(new String(ch, start, length));
        }
    }
}