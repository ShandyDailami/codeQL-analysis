import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_33443_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(new File("src/main/resources/test.xml"), xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}