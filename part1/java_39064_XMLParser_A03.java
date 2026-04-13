import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_39064_XMLParser_A03 extends DefaultHandler {

    private boolean isName = false;
    private boolean isAge = false;

    private String currentElement;
    private List<Person> persons = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if ("person".equals(qName)) {
            isName = true;
            persons.add(new Person());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)) {
            isName = false;
        } else if ("name".equals(qName)) {
            isAge = false;
        }

        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement == null) {
            return;
        }

        if (isName) {
            String name = new String(ch, start, length).trim();
            persons.get(persons.size() - 1).setName(name);
        } else if (isAge) {
            String age = new String(ch, start, length).trim();
            persons.get(persons.size() - 1).setAge(Integer.parseInt(age));
        }
    }

    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}