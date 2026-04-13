import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_08567_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";
    private List<Person> personList = new ArrayList<>();

    public class Person {
        String name;
        int age;

        public java_08567_XMLParser_A03(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = "";
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            String name = new String(ch, start, length);
            Person person = new Person(name, 0);
            personList.add(person);
        } else if (bAge) {
            int age = Integer.parseInt(new String(ch, start, length));
            Person person = new Person(currentElement, age);
            personList.add(person);
        }
    }

    public static void main(String[] args) {
        String xml = "<people>\n" +
                "  <person><name>John</name><age>30</age></person>\n" +
                "  <person><name>Jane</name><age>28</age></person>\n" +
                "</people>";

        MyXMLParser handler = new MyXMLParser();
        try {
            org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Person person : handler.personList) {
            System.out.println(person);
        }
    }
}