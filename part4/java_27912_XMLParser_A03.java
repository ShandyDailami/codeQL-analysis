import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_27912_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentValue = null;

    private List<Person> persons = new ArrayList<>();

    public class Person {
        public String name;
        public int age;

        public java_27912_XMLParser_A03(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            currentValue = "";
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            currentValue = attributes.getValue(0);
            bAge = false;
        } else if (bAge && qName.equalsIgnoreCase("name")) {
            currentValue = attributes.getValue(0);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            persons.add(new Person(currentValue, Integer.parseInt(currentValue)));
            currentValue = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentValue = new String(ch, start, length);
        }
    }
}