import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_35788_XMLParser_A08 extends DefaultHandler {
    private boolean isName = false;
    private boolean isAge = false;
    private String currentElement = "";
    private List<Person> persons = new ArrayList<>();

    public static class Person {
        private String name;
        private int age;

        public java_35788_XMLParser_A08(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            isName = true;
            isAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("age")) {
            isAge = false;
        } else if (qName.equals("person")) {
            persons.add(new Person(null, 0));
            isName = false;
            isAge = false;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("name")) {
            persons.get(persons.size() - 1).name = new String(ch, start, length);
        } else if (currentElement.equals("age")) {
            persons.get(persons.size() - 1).age = Integer.parseInt(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MySAXHandler handler = new MySAXHandler();

        // Replace with your actual XML file
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        parser.parse("src/main/resources/people.xml", handler);

        for (Person person : handler.persons) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}