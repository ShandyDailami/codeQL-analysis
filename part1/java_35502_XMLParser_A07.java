import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_35502_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private int age = 0;

    public static void main(String[] args) {
        String file = "src/main/resources/people.xml";
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            XmlParser handler = new XmlParser();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            // start a new person
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("person")) {
            // end a person
            System.out.println("Name: " + name + ", Age: " + age);
            name = null;
            age = 0;
            bName = false;
            bAge = false;
        } else if (bName && qName.equals("name")) {
            bName = false;
        } else if (bAge && qName.equals("age")) {
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }
}