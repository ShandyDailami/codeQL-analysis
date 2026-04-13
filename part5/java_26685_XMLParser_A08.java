import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_26685_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("sample.xml"), handler);
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
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                System.out.println("Person");
                return;
            }

            if (bName) {
                System.out.print("Name : ");
                bName = false;
            }

            if (bAge) {
                System.out.println("Age");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Do nothing
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (bName) {
                System.out.println(new String(chars, start, length));
            }
        }
    }
}