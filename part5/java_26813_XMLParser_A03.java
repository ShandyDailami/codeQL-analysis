import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_26813_XMLParser_A03 extends DefaultHandler {

    private String lastElement;
    private List<Person> persons = new ArrayList<>();

    private enum Context {
        NAME, AGE, ID
    }

    private static class Person {
        String name;
        int age;
        String id;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        if (qName.equals("person")) {
            Person person = new Person();
            person.id = attributes.getValue("id");
            persons.add(person);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (lastElement.equals("name")) {
            ((Person)persons.get(persons.size() - 1)).name = value;
        } else if (lastElement.equals("age")) {
            ((Person)persons.get(persons.size() - 1)).age = Integer.parseInt(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            persons.add(new Person());
        }
        lastElement = "";
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(MyXMLHandler.class.getResourceAsStream("/data.xml"), handler);
            for (Person person : handler.persons) {
                System.out.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}