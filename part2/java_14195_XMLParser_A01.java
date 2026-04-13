import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14195_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        try {
            parser.parse(new File("data.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bPerson = false;
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = true;
            } else if (bPerson && qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (bPerson && qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bPerson && bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bPerson && bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}