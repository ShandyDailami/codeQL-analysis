import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_00716_XMLParser_A08 extends DefaultHandler {

    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Inside Person Element : " + localName);
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.println("Name : " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println("Age : " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of Person Element");
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            File inputFile = new File("src/main/resources/people.xml");
            XMLEventReader reader = org.xml.sax.helpers.XMLReaderFactory.createXMLReader();
            parser.setProperty("http://xml.org/sax/static", "true");

            MyXMLHandler myHandler = new MyXMLHandler();
            parser.setContentHandler(myHandler);
            reader.setContentHandler(myHandler);

            System.out.println("XML Parsing Complete");

            //parse XML using SAX
            parser.parse(inputFile, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}