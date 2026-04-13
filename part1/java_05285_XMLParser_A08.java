import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05285_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("example.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
            if (qName.equals("name")) {
                bName = true;
            }
            if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.print("Name: ");
                System.out.print(new String(ch, start, length));
                System.out.print(" ");
            }
            if (bAge) {
                System.out.print("Age: ");
                System.out.print(new String(ch, start, length));
                System.out.println();
            }
        }
    }
}