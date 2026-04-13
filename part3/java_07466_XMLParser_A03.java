import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_07466_XMLParser_A03 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;
    private Person currentPerson;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (localName.equalsIgnoreCase("person")) {
            currentPerson = new Person();
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                currentElement = "name";
                bName = false;
            } else if (bAge) {
                currentElement = "age";
                bAge = false;
            }
            System.out.println("Start of " + localName);
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (localName.equalsIgnoreCase("person")) {
            System.out.println("End of " + localName);
            System.out.println("Person: " + currentPerson.getName() + ", "
                    + currentPerson.getAge());
        } else {
            if (currentElement.equalsIgnoreCase("name")) {
                currentPerson.setName(qName);
            } else if (currentElement.equalsIgnoreCase("age")) {
                currentPerson.setAge(Integer.parseInt(qName));
            }
            currentElement = "";
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName || bAge) {
            String data = new String(ch, start, length);
            if (bName) {
                currentPerson.setName(data);
            } else if (bAge) {
                currentPerson.setAge(Integer.parseInt(data));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyXMLParser());
        reader.parse("src/test.xml");
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