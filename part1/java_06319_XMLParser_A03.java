import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_06319_XMLParser_A03 {

    public static void parseXML(String fileName) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(fileName, saxHandler);

        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parseXML("example.xml");
    }
}

class SAXHandler implements javax.xml.parsers.SAXHandler {

    private boolean isElement;
    private StringBuilder elementData;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        isElement = true;
        elementData = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        if (isElement) {
            isElement = false;
            // Perform security-sensitive operations related to A03_Injection here
            // For example, print the element data
            System.out.println("Element: " + elementData.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        if (isElement) {
            elementData.append(new String(ch, start, length));
        }
    }
}