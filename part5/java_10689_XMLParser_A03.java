import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10689_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("input.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        String qName = "";
        String age = "";
        String name = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            qName = qName.replace("QName", "");

            if (qName.equalsIgnoreCase("Person")) {
                bName = true;
                bAge = true;
            }

            if (bName && qName.equalsIgnoreCase("Name")) {
                bName = false;
                name = attributes.getValue("attribute");
            }

            if (bName && qName.equalsIgnoreCase("Age")) {
                bAge = false;
                age = attributes.getValue("attribute");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                name = new String(ch, start, length);
            }

            if (bAge) {
                age = new String(ch, start, length);
            }
        }
    }
}