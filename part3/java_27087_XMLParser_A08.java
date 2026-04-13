import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_27087_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));

        saxParser.setProperty( "com.sun.xml.internal.fastinfoset.tag-prefixes", "infoset");
        saxParser.setProperty( "com.sun.xml.internal.fastinfoset.omit-decl-prefix", "true");
        saxParser.setProperty( "com.sun.xml.internal.fastinfoset.xmlversion", "1.0");

        // Set up the SAX handler
        MySAXHandler saxHandler = new MySAXHandler();
        saxParser.parse(new InputSource(new File("input.xml")), saxHandler);
    }
}

class MySAXHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Handle XML element here
        // For instance, print out the name of the XML element
        System.out.println("Start element: " + qName);

        // You can also handle other attributes here
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle XML element here
        // For instance, print out the name of the XML element
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Handle character data here
        // For instance, print out the character data
        String data = new String(ch, start, length);
        System.out.println("Character data: " + data);
    }
}