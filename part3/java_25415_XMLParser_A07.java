import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25415_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, false);

            MyContentHandler myContentHandler = new MyContentHandler();

            saxParser.parse(new File("src/main/resources/sample.xml"), myContentHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}