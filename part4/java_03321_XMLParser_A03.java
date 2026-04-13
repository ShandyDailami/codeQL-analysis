import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_03321_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());

            // Load the XML file
            saxParser.parse(new File("src/main/resources/data.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    private boolean isName = false;
    private boolean isAttribute = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("attribute")) {
            isAttribute = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        if (isName) {
            // Security-sensitive operation: No use of external frameworks
            System.out.println("Name found: " + qName);
            isName = false;
        } else if (isAttribute) {
            // Security-sensitive operation: No use of external frameworks
            System.out.println("Attribute found: " + qName);
            isAttribute = false;
        }
    }
}