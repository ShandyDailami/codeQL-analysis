import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_20007_XMLParser_A01 extends DefaultHandler {

    private boolean isName = false;
    private boolean isAge = false;
    private String currentElement;
    private List<Person> persons = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("person")) {
            persons.add(new Person());
        } else if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("age")) {
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
            isName = false;
            isAge = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            persons.get(persons.size() - 1).setName(new String(ch, start, length));
        } else if (isAge) {
            persons.get(persons.size() - 1).setAge(Integer.parseInt(new String(ch, start, length)));
        }
    }

    public static class Person {
        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}