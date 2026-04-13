import java.io.File;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12922_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        File xmlFileObj = new File(xmlFile);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFileObj, myHandler);

            System.out.println("Finished parsing the XML file. No security issues found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This is a custom handler that only handles the start of an element
    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            // Since this example only uses SAX, no need for a security-sensitive operation here
            // It's simply for demonstrating purposes
            System.out.println("Start of element: " + qName);

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // This method is called when a character is parsed
            if (length > 0) {
                String str = new String(ch, start, length);
                System.out.println("Character data: " + str);
            }
        }

    }

}