import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_18047_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/input.xml"; // Replace with your XML file path
        XMLParserExample example = new XMLParserExample();
        example.parseXMLFile(xmlFile);
    }

    private void parseXMLFile(String xmlFile) {
        try {
            File inputFile = new File(xmlFile);
            FileReader fileReader = new FileReader(inputFile);
            XMLStreamReader xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(fileReader);

            // Create a new instance of XMLReader
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

            // Create a new instance of SAXHandler
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xmlReader, saxHandler);

            xmlReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (XMLStreamException e) {
            System.out.println("Error parsing XML stream.");
        } catch (ParserConfigurationException e) {
            System.out.println("Error creating parser.");
        }
    }

    // SAXHandler is a simple implementation of the SAXEventHandler
    // for parsing the XML data. It ignores all elements and just prints
    // the content of the XML elements.
    private class SAXHandler implements SAXEventHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(String content, int start, int length) throws SAXException {
            System.out.println("Characters: " + content);
        }
    }
}