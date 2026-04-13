import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_04020_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";
    private List<Person> personList = new ArrayList<>();

    public static class Person {
        String name;
        int age;

        public java_04020_XMLParser_A03(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                bName = false;
            } else if (bAge) {
                bAge = false;
                currentElement = "";
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
            currentElement = "";
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            personList.add(new Person(currentElement, 0));
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            personList.add(new Person(currentElement, Integer.parseInt(currentElement)));
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentElement = new String(ch, start, length);
        }
    }
}