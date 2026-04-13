import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_02767_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }

    static class MyHandler extends DefaultHandler {

        boolean bStart = false;
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bStart = true;

            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name : " + attributes.getValue("name"));
                System.out.println("Age : " + attributes.getValue("age"));
            } else if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bStart = false;

            if (qName.equalsIgnoreCase("person")) {
                System.out.println("\nEnd of Person");
            } else if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bStart) {
                if (bName) {
                    System.out.print("Name : ");
                    bName = false;
                } else if (bAge) {
                    System.out.print("Age : ");
                    bAge = false;
                }
                System.out.print(new String(ch, start, length));
            }
        }
    }
}