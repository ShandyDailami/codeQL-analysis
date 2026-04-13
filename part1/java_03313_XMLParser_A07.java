import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03313_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/people.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean nameFound = false;
        private boolean ageFound = false;
        private String name = null;
        private String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                // Start of 'person' tag
                nameFound = false;
                ageFound = false;
            } else if (qName.equals("name")) {
                // Start of 'name' tag
                nameFound = true;
            } else if (qName.equals("age")) {
                // Start of 'age' tag
                ageFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                // End of 'person' tag
                System.out.println("Name: " + name + ", Age: " + age);
            } else if (qName.equals("name")) {
                // End of 'name' tag
                nameFound = false;
            } else if (qName.equals("age")) {
                // End of 'age' tag
                ageFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound) {
                name = new String(ch, start, length);
            } else if (ageFound) {
                age = new String(ch, start, length);
            }
        }
    }
}