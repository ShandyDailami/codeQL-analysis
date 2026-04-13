import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLOverruns.OverrunsException;

public class java_31476_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Person")) {
                bName = true;
                bAge = true;
            }
            if (qName.equals("Name")) {
                bName = true;
            } else if (qName.equals("Age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Perform security-sensitive operation related to injection
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                // Perform security-sensitive operation related to injection
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {
        SAXParser saxParser = XMLParser.newInstance();
        MyHandler myHandler = new MyHandler();
        saxParser.setContentHandler(myHandler);
        File inputFile = new File("example.xml");
        try {
            saxParser.parse(inputFile);
        } catch (SAXException | IOException | OverrunsException e) {
            e.printStackTrace();
        }
    }
}