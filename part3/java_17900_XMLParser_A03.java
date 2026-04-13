import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_17900_XMLParser_A03 extends DefaultHandler {

    private String thisElement;
    private boolean bName;
    private boolean bAge;

    public java_17900_XMLParser_A03() {
        this.bName = false;
        this.bAge = false;
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, XMLObject obj)
            throws SAXException {
        this.thisElement = qualifiedName;

        if (qualifiedName.equals("person")) {
            bName = false;
            bAge = false;
        } else if (this.thisElement.equals("name")) {
            bName = true;
        } else if (this.thisElement.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MySAXHandler());
        reader.parse("example.xml");
    }
}