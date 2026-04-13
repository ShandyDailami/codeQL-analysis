import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class java_27013_XMLParser_A08 extends DefaultHandler {
    private Set<String> tags = new HashSet<>();
    private String currentElement = null;

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";

        XMLParser parser = XMLParserFactory.createParser(
                new File(xmlFilePath),
                new SAXErrorHandler(),
                new XMLIntegrityFailureValidator()
        );

        try {
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!tags.contains(currentElement) && !tags.contains(qName)) {
            System.out.println("Integrity failure detected in XML file: " + localName);
        }

        currentElement = null;
    }
}