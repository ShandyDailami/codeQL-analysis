import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40729_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        String qName = "";
        String name = "";
        int age = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = qName.replace("people", "");
            bName = qName.equalsIgnoreCase("person");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bName) {
                bName = false;
                System.out.println("Name: " + name);
            } else if (bAge) {
                bAge = false;
                System.out.println("Age: " + age);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            } else if (bAge) {
                age = Integer.parseInt(new String(ch, start, length));
            }
        }
    }
}