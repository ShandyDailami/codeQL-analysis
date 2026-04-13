import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32434_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse(new File("sample.xml"), new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start of Person");
                bName = true;
                bAge = true;
                System.out.println("Name : " + attributes.getValue("name"));
                System.out.println("Age : " + attributes.getValue("age"));
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
                System.out.println("End of Person");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Character's Data : " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Character's Data : " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}