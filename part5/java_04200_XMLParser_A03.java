import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04200_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
            public void endDocument() {
                System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("Start of Person : Name=" + attributes.getValue("name"));
                bName = true;
            }
            else if (qName.equals("age")) {
                System.out.println("Start of Age : Age=" + attributes.getValue("age"));
                bAge = true;
            }
        }

        @Override
        public java_04200_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("End of Person");
                bName = false;
            }
            else if (qName.equals("age")) {
                System.out.println("End of Age");
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name=" + new String(ch, start, length));
                bName = false;
            }
            else if (bAge) {
                System.out.println("Age=" + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}