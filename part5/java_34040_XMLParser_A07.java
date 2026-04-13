import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34040_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("your_file.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + attributes.getValue("name"));
                System.out.println("Age: " + attributes.getValue("age"));
                bName = true;
                bAge = true;
            }

            if (qName.equalsIgnoreCase("name"))
                bName = true;
            if (qName.equalsIgnoreCase("age"))
                bAge = true;
        }

        @Override
        public java_34040_XMLParser_A07(String uri, String localName, String qName)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                if (bName) {
                    System.out.println("Person record successfully parsed");
                    bName = false;
                    bAge = false;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}