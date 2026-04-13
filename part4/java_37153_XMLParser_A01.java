import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_37153_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("input.xml"), new MyHandler());
        } catch (SAXParseException e) {
            System.out.println("Parsing error at line: " + e.getLineNumber());
            e.printStackTrace(System.out);
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
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                System.out.println("--- Start of person ---");
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                System.out.println("Name: " + attributes.getValue(""));
            } else if (bAge && qName.equals("age")) {
                System.out.println("Age: " + attributes.getValue(""));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("--- End of person ---");
                bName = false;
                bAge = false;
            }
        }
    }
}