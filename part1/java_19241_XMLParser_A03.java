import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_19241_XMLParser_A03 extends DefaultHandler {
    private String lastElementName;

    public java_19241_XMLParser_A03() {
        // Create a SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a SAXParser using the factory
        SAXParser saxParser = factory.newSAXParser();

        // Create an XMLParser
        saxParser.setContentHandler(this);

        try {
            // Parse the XML file
            saxParser.parse(new File("sample.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastElementName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        lastElementName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (lastElementName != null) {
            // Here, you can handle the characters safely
            System.out.println(lastElementName + ": " + new String(ch, start, length));
        }
    }
}