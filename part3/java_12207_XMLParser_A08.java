import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;

public class java_12207_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bValue = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bName) {
                System.out.print("name: " + localName + "\n");
                bName = false;
            } else if (bValue) {
                System.out.print("value: " + localName + "\n");
                bValue = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your xml file
        XMLParser parser = XMLValidator.newSAXParser(new MyHandler());
        parser.parse(xmlFile);
    }
}