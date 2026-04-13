import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04958_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create the handler
            MyHandler myHandler = new MyHandler();

            // Parse the XML file
            saxParser.parse(inputFile, myHandler);

            // Print the parsed data
            System.out.println("Parsed XML data: " + myHandler.getXmlData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define a SAX handler
class MyHandler implements javax.xml.parsers.SAXHandler {
    private StringBuilder xmlData;

    public java_04958_XMLParser_A08() {
        this.xmlData = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        xmlData.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        xmlData.append(" ").append(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        xmlData.append(new String(ch, start, length));
    }

    public String getXmlData() {
        return xmlData.toString();
    }
}