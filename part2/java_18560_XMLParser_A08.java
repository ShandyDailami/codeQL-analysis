import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_18560_XMLParser_A08 extends DefaultHandler {

    public static void main(String[] args) throws ParserConfigurationException, IOException {
        String inputFile = "/path/to/your/input.xml";
        String outputFile = "/path/to/your/output.txt";

        parse(inputFile, outputFile);
    }

    private static void parse(String inputFile, String outputFile) throws ParserConfigurationException, IOException {
        // Load XML document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new File(inputFile)));

        // Set up SAX parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReader(new StringReader(inputFile)));

        // Set up OutputWriter
        Writer out = new OutputStreamWriter(new FileOutputStream(outputFile));

        // Set up SAXHandler
        MyXMLParser handler = new MyXMLParser();
        saxParser.parse(doc, handler);

        // Close OutputWriter
        out.close();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}