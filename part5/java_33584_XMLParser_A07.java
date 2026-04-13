import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33584_XMLParser_A07 {

    // SAX parser for parsing XML file
    private SAXParser saxParser;

    // XML reader
    private XMLReader xmlReader;

    // File to parse
    private File xmlFile;

    public java_33584_XMLParser_A07(File xmlFile) {
        this.xmlFile = xmlFile;
        initSAXParser();
    }

    // Initialize SAX parser
    private void initSAXParser() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            saxParser = spf.newSAXParser(xmlFile.toURI().toString());
        } catch (IOException e) {
            System.out.println("Error while initializing SAXParser: " + e.getMessage());
            System.exit(1);
        }
    }

    // Start parsing XML
    public void parseXML() {
        try {
            xmlReader = xmlReader.newInstance();
            xmlReader.setContentHandler(new AuthFailureContentHandler());
            saxParser.parse(xmlFile, xmlReader);
        } catch (SAXException e) {
            System.out.println("Error while parsing XML: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading XML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        AuthFailureXMLParser parser = new AuthFailureXMLParser(xmlFile);
        parser.parseXML();
    }
}