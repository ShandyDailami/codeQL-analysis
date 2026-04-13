import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04808_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new File("input.xml"));
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler);

            System.out.println("Name: " + myHandler.getName());
            System.out.println("Age: " + myHandler.getAge());
            System.out.println("Address: " + myHandler.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private String name;
    private int age;
    private String address;
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bAddress = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // start of person element, create new instance
            Person person = new Person();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("address")) {
            bAddress = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // end of person element
            bName = false;
            bAge = false;
            bAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            this.name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            this.age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        } else if (bAddress) {
            this.address = new String(ch, start, length);
            bAddress = false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}