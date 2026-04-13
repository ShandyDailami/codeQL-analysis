import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03676_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new XMLLoader(xmlFile));
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);

            parser.parse(new File(xmlFile.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                System.out.println("Person (" + qName + ")");
                return;
            }
            if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("  Name: ");
                bName = false;
            }
            if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("  Age: ");
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("  Name: " + new String(ch, start, length));
            }
            if (bAge) {
                System.out.println("  Age: " + new String(ch, start, length));
            }
        }
    }
}