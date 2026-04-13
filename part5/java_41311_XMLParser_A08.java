import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_41311_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a SAXParserFactory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Create a SAXParser
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        // Create a custom XMLHandler
        XMLHandler xmlHandler = new XMLHandler();

        // Parse the XML file
        saxParser.parse("src/main/resources/security-sensitive-operations-example.xml", xmlHandler);

        // Output the result
        xmlHandler.printResult();
    }
}