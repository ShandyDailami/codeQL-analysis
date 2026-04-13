import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

public class java_30704_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserExample myHandler = new SAXParserExample();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse("src/main/resources/sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserExample extends DefaultHandler {
    boolean bName;
    boolean bAge;
    String name;
    String age;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            bName = true;
            bAge = false;
        } else if (bName && qName.equalsIgnoreCase("Name")) {
            bName = false;
            name = "";
        } else if (bName && qName.equalsIgnoreCase("Age")) {
            bAge = false;
            age = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("End of Person");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

}