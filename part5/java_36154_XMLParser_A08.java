import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_36154_XMLParser_A08 {

    public static void main(String[] args) {
        // Load the XML file
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Parse the XML using SAX
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(inputStream, myHandler);
    }

    // Handler for SAX
    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }
            
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            }
            
            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
            
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
            
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            }
            
            if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}