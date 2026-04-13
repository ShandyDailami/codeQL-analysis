import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14478_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new File("data.xml"));

            // Create an instance of the handler
            MyHandler handler = new MyHandler();

            // Use the parser to parse the XML file
            parser.parse(new File("data.xml"), handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Define a handler to handle the parsed XML data
    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String name = null;
        private int age = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bAge) {
                age = Integer.parseInt(new String(ch, start, length));
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name + ", Age: " + age);
                bName = false;
                bAge = false;
                name = null;
                age = 0;
            }
        }
    }
}