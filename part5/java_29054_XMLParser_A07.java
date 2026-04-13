import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_29054_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Read XML file
            File xmlFile = new File("example.xml");
            saxParser.parse(xmlFile, new XMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}