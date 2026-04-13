import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_27199_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create a File object for the XML file
            File xmlFile = new File("path_to_your_file.xml");

            // Create a new SAXHandler that will be called for each element in the XML file
            XmlHandler xmlHandler = new XmlHandler();

            // Parse the XML file
            saxParser.parse(xmlFile, xmlHandler);

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

// Implement the SAXHandler to handle the elements in the XML file
class XmlHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}