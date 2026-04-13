import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.sax2.XMLReaderImpl;
import org.xml.sax.helpers.DefaultHandler;

public class java_40359_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // Specify your XML file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        BasicHandler handler = new BasicHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
                printAttributes(attributes);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File(xmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAttributes(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }
}