import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_30072_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your XML file
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        try {
            File inputFile = new File(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlContentHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing file: " + e.getMessage());
        }
    }
}

class XmlContentHandler implements org.xml.sax.ContentHandler {
    private boolean tag = false;
    private String tagName = "";
    private String tagValue = "";

    @Override
    public void startDocument() {
        System.out.println("Start of XML file");
    }

    @Override
    public void endDocument() {
        System.out.println("End of XML file");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        tag = true;
        tagName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        tag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (tag) {
            tagValue = new String(ch, start, length);
            System.out.println("Tag: " + tagName + ", Value: " + tagValue);
        }
    }

    @Override
    public void fatalError(String error) {
        System.out.println("Fatal Error: " + error);
    }

    @Override
    public void error(String error, SAXException e) {
        System.out.println("Error: " + error + " at line " + e.getLineNumber());
    }

    @Override
    public void warning(String warning) {
        System.out.println("Warning: " + warning);
    }
}