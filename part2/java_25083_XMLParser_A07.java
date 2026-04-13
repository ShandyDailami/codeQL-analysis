import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_25083_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true); // Creating new parser
            MyHandler myHandler = new MyHandler();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(myHandler);

            // Parsing the XML file
            reader.parse(new File("sample.xml")); // Change with your xml file

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    boolean bID = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
            bID = true;

            // Start of a new person
            System.out.println("Name: " + attributes.getValue("name"));
            System.out.println("Age: " + attributes.getValue("age"));
            System.out.println("ID: " + attributes.getValue("id"));
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        } else if (qName.equals("id")) {
            bID = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
            bID = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (bID) {
            System.out.println("ID: " + new String(ch, start, length));
        }
    }
}