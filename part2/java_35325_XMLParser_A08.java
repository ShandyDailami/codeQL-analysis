import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35325_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create SAXParserFactory
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Create SAXParser
            SAXParser saxParser = spf.newSAXParser();

            // Create File
            File inputFile = new File("input.xml");

            // Parse XML
            saxParser.parse(inputFile, new XMLHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}