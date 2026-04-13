import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27691_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bId = false;
    
    private String name;
    private int age;
    private String id;

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
        if (qName.equals("person")) {
            return;
        }
        if (qName.equals("name")) {
            bName = true;
            return;
        }
        if (qName.equals("age")) {
            bAge = true;
            return;
        }
        if (qName.equals("id")) {
            bId = true;
            return;
        }

        // Start of Injection
        // End of Injection
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Id: " + id);
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        }
        if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        }
        if (bId) {
            id = new String(ch, start, length);
            bId = false;
        }
    }
}