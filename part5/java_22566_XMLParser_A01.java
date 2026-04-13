import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22566_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(inputFile, saxHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("student")) {
                System.out.println("Name: " + attributes.getValue("name"));
                System.out.println("Age: " + attributes.getValue("age"));
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("student")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName && bAge) {
                System.out.println("Student's name and age: " + new String(ch, start, length));
            } else {
                super.characters(ch, start, length);
            }
        }
    }
}