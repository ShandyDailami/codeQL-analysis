import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20745_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {

        private boolean nameFound = false;
        private boolean ageFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                this.nameFound = true;
            } else if (qName.equals("age")) {
                this.ageFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("Person found!");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (this.nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
                this.nameFound = false;
            } else if (this.ageFound) {
                System.out.println("Age: " + new String(ch, start, length));
                this.ageFound = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(inputFile, MyHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}