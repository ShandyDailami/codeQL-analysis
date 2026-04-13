import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_12287_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a SAX parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Parse the XML file
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(new File("input.xml"), xmlHandler);

            // Print results
            System.out.println("Number of tags: " + xmlHandler.getNumTags());
            System.out.println("Number of attributes: " + xmlHandler.getNumAttributes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {
    private int numTags = 0;
    private int numAttributes = 0;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        numTags++;
        System.out.println("Start tag: " + qName);

        if (attributes.getLength() > 0) {
            numAttributes++;
            System.out.println("Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute " + (i + 1) + ": " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        System.out.println("End tag: " + qName);
    }

    public void startPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {
        // Not implemented
    }

    public void endPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {
        // Not implemented
    }

    public int getNumTags() {
        return numTags;
    }

    public int getNumAttributes() {
        return numAttributes;
    }
}