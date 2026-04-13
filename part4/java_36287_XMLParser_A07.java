import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_36287_XMLParser_A07 extends DefaultHandler {
    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String file = "test.xml";

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MySAXHandler());
        reader.parse(new File(file));
    }
}