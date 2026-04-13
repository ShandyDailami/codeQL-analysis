import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_06547_XMLParser_A08 extends DefaultHandler {

    private boolean isName = false;
    private boolean isAge = false;
    private boolean isAddress = false;
    private String name;
    private int age;
    private String address;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = false;
            isAge = true;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = false;
            isAddress = true;
        } else if (qName.equalsIgnoreCase("address")) {
            isAddress = false;
        } else if (isName) {
            name = localName;
        } else if (isAge) {
            age = Integer.parseInt(localName);
        } else if (isAddress) {
            address = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // Handle person data here
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAge || isAddress) {
            String value = new String(ch, start, length);
            if (isAge) {
                age = Integer.parseInt(value);
            } else if (isAddress) {
                address = value;
            }
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

public class MyXMLParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "path_to_your_xml_file.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(new MyXMLHandler());
        reader.parse(new File(xmlFile));
    }
}