import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_31393_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new File("data.xml"));
            XMLEventReader reade = sp.getXMLReader();

            SAXHandler handler = new SAXHandler();
            sp.setContentHandler(handler);
            sp.parse("data.xml", handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Person details : ");
                bName = true;
                bAge = true;
            } else if (bName) {
                System.out.print("Name : " + localName + " ");
                bName = false;
            } else if (bAge) {
                System.out.println("Age : " + localName);
                bAge = false;
            }
        }
    }
}