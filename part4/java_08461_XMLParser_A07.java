import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_08461_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            File xmlFile = new File("resources/authfailure.xml");
            SAXParserHandler saxParserHandler = new SAXParserHandler();

            saxParser.parse(xmlFile, saxParserHandler);
            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}