import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_28559_XMLParser_A03 extends DefaultHandler {

    private boolean inPerson;
    private boolean inAddress;
    private boolean inName;

    private String name;
    private String address;
    private String phone;

    private List<Person> persons = new ArrayList<>();

    public class Person {
        public String name;
        public String address;
        public String phone;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Person")) {
            persons.add(new Person());
            inPerson = true;
        } else if (qName.equals("Name")) {
            inName = true;
        } else if (qName.equals("Address")) {
            inAddress = true;
        } else if (qName.equals("Phone")) {
            inPerson = false;
            inName = false;
            inAddress = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Person")) {
            inPerson = false;
        } else if (qName.equals("Name")) {
            inName = false;
        } else if (qName.equals("Address")) {
            inAddress = false;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (inPerson) {
            Person person = persons.get(persons.size() - 1);
            if (inName) {
                person.name = new String(chars, start, length);
            } else if (inAddress) {
                person.address = new String(chars, start, length);
            } else if (inAddress) {
                person.phone = new String(chars, start, length);
            }
        }
    }
}