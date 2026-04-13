import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38722_XMLParser_A03 extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    public java_38722_XMLParser_A03() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
            System.out.println("Person attributes:");
        } else if (bName) {
            System.out.println("Name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            System.out.println(new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.print("Age: ");
            System.out.println(new String(ch, start, length));
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File inputFile = new File("src/main/resources/people.xml");
        parser.parse(inputFile, new MyHandler());
    }
}