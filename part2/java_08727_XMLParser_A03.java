import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.util.ParserDelegationHelper;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_08727_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new ParserDelegationHelper(new DefaultHandler()));
        File inputFile = new File("input.xml");
        try {
            parser.parse(inputFile, new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
            // Process the element here.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End of person element");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}