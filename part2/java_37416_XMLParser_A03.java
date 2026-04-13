import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_37416_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;

    private List<Person> persons = new ArrayList<>();
    private Person current = null;

    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            current = new Person();
            current.setName(attributes.getValue("name"));
            current.setAge(attributes.getValue("age"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            persons.add(current);
            current = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            current.setName(new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            current.setAge(new String(ch, start, length));
            bAge = false;
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public static void main(String[] args) throws Exception {
        MyXMLHandler handler = new MyXMLHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);

        List<Person> persons = handler.getPersons();
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}