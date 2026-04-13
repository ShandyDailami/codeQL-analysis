import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_06669_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Create a new handler
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new DefaultHandler());

            // Parse the XML
            saxParser.parse(new InputSource(new StringReader(doc.getFirstChildElement().getFirstChild().getNodeValue())), new XMLHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define your own SAXHandler (XMLHandler)
class XMLHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Start of XML parsing
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // End of XML parsing
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Print parsed characters
        System.out.println(new String(ch, start, length));
    }
}