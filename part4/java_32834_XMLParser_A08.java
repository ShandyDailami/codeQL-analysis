import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_32834_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create SAXParserFactory
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Create SAXParser
            SAXParser saxParser = spf.newSAXParser();

            // Create File object
            File inputFile = new File("input.xml");

            // Parse XML file
            saxParser.parse(inputFile, new MyHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        // This is a security-sensitive operation.
        // For example, it may print out the attributes of the parsed XML element:
        System.out.println("Parsing XML element: " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute " + (i + 1) + ": " + attributes.getQualifiedName(i) + "=" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        // This is a security-sensitive operation.
        // It may print out the end of the parsed XML element:
        System.out.println("End of XML element: " + qName);
    }

    @Override
    public void startDocument(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        // This is a security-sensitive operation.
        // It may print out the start of the parsed XML document:
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        // This is a security-sensitive operation.
        // It may print out the end of the parsed XML document:
        System.out.println("End of XML document");
    }
}