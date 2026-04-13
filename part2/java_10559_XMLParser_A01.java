import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_10559_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // use false if you want to validate XML against DTD
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler); // replace "input.xml" with your XML file path
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bPerson = false;
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) bPerson = true;
            if (qName.equalsIgnoreCase("name")) bName = true;
            if (qName.equalsIgnoreCase("age")) bAge = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) bPerson = false;
            if (qName.equalsIgnoreCase("name")) bName = false;
            if (qName.equalsIgnoreCase("age")) bAge = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bPerson) System.out.println("Person: ");
            if (bName) System.out.print("Name: ");
            if (bAge) System.out.print("Age: ");
        }
    }
}