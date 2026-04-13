import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_32767_XMLParser_A01 extends DefaultHandler {

    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAge = false;

    private String name;
    private String age;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPerson) {
            System.out.println("Person found");
            isPerson = false;
        } else if (isName) {
            name = new String(ch, start, length);
            System.out.println("Name: " + name);
            isName = false;
        } else if (isAge) {
            age = new String(ch, start, length);
            System.out.println("Age: " + age);
            isAge = false;
        }
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyXMLParser());
        try {
            reader.parse("src/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}