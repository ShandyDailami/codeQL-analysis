// XML Parsing using Java's built-in libraries

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_40726_XMLParser_A08 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        XMLReader xmlReader;

        try {
            // Create an XMLReader object
            xmlReader = XMLReaderFactory.createXMLReader();

            // Create a custom handler
            XMLHandler handler = new XMLHandler();
            xmlReader.setContentHandler(handler);

            // Parse the XML file
            xmlReader.parse(new InputSource(new File(fileName)));

            // Print the parsed data
            for(String str : handler.getData()){
                System.out.println(str);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private List<String> data = new ArrayList<>();
    private StringBuilder currentValue = new StringBuilder();

    public List<String> getData() {
        return data;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.add(currentValue.toString());
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