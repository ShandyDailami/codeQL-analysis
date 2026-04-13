import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03416_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("employees.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                bName = true;
                bAge = false;
            } else if (bName && qName.equals("name")) {
                name = attributes.getValue("id");
                bName = false;
            } else if (bName && qName.equals("age")) {
                age = attributes.getValue("id");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("employee")) {
                System.out.println("Name: " + name + ", Age: " + age);
                bName = false;
                bAge = false;
                name = null;
                age = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName)
                name = new String(ch, start, length);
            if (bAge)
                age = new String(ch, start, length);
        }

    }
}