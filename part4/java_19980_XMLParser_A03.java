import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_19980_XMLParser_A03 {

    public static void main(String[] args) throws Exception {

        // Step 1: Creating a SAXParser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Step 2: Setting a new XML Content
        String xmlContent = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend.</body>\n" +
                "</note>";

        // Step 3: Parsing the XML Content
        saxParser.parse(new StringReader(xmlContent), new XMLHandler());

    }

}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {

        System.out.println("Start Element: " + qName);

        String to = attributes.getValue("to");
        String from = attributes.getValue("from");
        String heading = attributes.getValue("heading");
        String body = attributes.getValue("body");

        System.out.println("To: " + to);
        System.out.println("From: " + from);
        System.out.println("Heading: " + heading);
        System.out.println("Body: " + body);

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {

        System.out.println("End Element: " + qName);

    }

}