import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class java_15501_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    public static void main(String[] args) {
        String file = "src/main/resources/people.xml";
        new MyXMLParser().parse(file);
    }

    public void parse(String file) {
        try {
            DOMParser parser = new DOMParser();
            parser.setDocumentBuilders();
            FileInputStream in = new FileInputStream(file);
            parser.parse(in);
            printPersons(parser.getPersons());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List getPersons() {
        return persons;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        if (qName.equals("person")) {
            persons.add(new Person());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentElement.equals("name")) {
            persons.get(persons.size() - 1).setName(value);
            bName = true;
        } else if (currentElement.equals("age")) {
            persons.get(persons.size() - 1).setAge(Integer.parseInt(value));
            bAge = true;
        }
    }

    class Person {
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