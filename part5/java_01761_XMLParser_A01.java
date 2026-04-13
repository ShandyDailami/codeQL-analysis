import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_01761_XMLParser_A01 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    public static void main(String[] args) {
        String fileName = "src/main/resources/sample.xml";
        File file = new File(fileName);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLParserLegacy handler = new XMLParserLegacy();
            saxParser.parse(file, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Found a person");
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.println("Found the name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println("Found the age: " + attributes.getValue(0));
            bAge = false;
        }
    }
}