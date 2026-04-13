import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_31896_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserExample saxParserExample = new SAXParserExample();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParserExample);
            xmlReader.parse(new File("input.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserExample extends DefaultHandler {

    boolean bName;
    boolean bAge;
    String temp;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Person found");
            bName = false;
            bAge = false;
        } else if (qName.equalsIgnoreCase("name")) {
            System.out.println("Name found");
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            System.out.println("Age found");
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Person ended");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}