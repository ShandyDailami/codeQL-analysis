import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_20184_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Parsing the XML file
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse("src/main/resources/sample.xml", xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}