import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;

public class java_37894_XMLParser_A03 {

    public static void main(String[] args) throws Exception {

        String xmlFilePath = "src/main/resources/test.xml";  // replace this with the path of your xml file

        // SAX Parsing
        SAXParserHandler handler = new SAXParserHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLParser parser = factory.newSAXParser(new InputSource(new FileInputStream(xmlFilePath)));
        parser.setContentHandler(handler);
        parser.parse(new File(xmlFilePath));
    }

    static class SAXParserHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equalsIgnoreCase("person")){
                // Do nothing
            }
            else if(qName.equalsIgnoreCase("name")){
                bName = true;
            }
            else if(qName.equalsIgnoreCase("age")){
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("person")){
                // Do nothing
            }
            else if(qName.equalsIgnoreCase("name")){
                bName = false;
            }
            else if(qName.equalsIgnoreCase("age")){
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bName){
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            }
            else if(bAge){
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}