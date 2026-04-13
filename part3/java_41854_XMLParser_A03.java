import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_41854_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement;
    private List<Person> persons = new ArrayList<>();

    public static class Person {
        public String name;
        public int age;

        public java_41854_XMLParser_A03(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String s = new String(ch, start, length);
            if(currentElement.equals("name")) {
                s = sanitizeInput(s); // sanitizeInput is a method to filter possible security threats
                Person person = new Person(s, 0);
                persons.add(person);
            } else {
                bName = false;
            }
        } else if (bAge) {
            String s = new String(ch, start, length);
            if(currentElement.equals("age")) {
                int age = Integer.parseInt(s); // we assume that age is always a valid integer
                for(Person person : persons) {
                    if(person.age == age) { // sanitizeInput is a method to filter possible security threats
                        person.name = sanitizeInput(person.name);
                    }
                }
            } else {
                bAge = false;
            }
        }
    }

    private String sanitizeInput(String input) {
        // Implement sanitizeInput method to filter out possible security threats here
        // For simplicity, we just return the input as it is
        return input;
    }
}