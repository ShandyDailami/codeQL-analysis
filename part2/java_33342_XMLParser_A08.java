import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_33342_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("src/sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean idFound = false;
        private boolean ageFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                this.nameFound = true;
                this.idFound = true;
                this.ageFound = true;
            } else if (qName.equals("name")) {
                this.nameFound = true;
            } else if (qName.equals("id")) {
                this.idFound = true;
            } else if (qName.equals("age")) {
                this.ageFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                if (!this.nameFound || !this.idFound || !this.ageFound) {
                    System.out.println("Person attributes not found!");
                }
            } else if (qName.equals("name")) {
                this.nameFound = false;
            } else if (qName.equals("id")) {
                this.idFound = false;
            } else if (qName.equals("age")) {
                this.ageFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (this.nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (this.idFound) {
                System.out.println("ID: " + new String(ch, start, length));
            } else if (this.ageFound) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}