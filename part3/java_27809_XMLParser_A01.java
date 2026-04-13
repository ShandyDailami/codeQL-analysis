import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class java_27809_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        CustomSecurityManager customSecurityManager = new CustomSecurityManager();
        CustomXMLParser customXMLParser = new CustomXMLParser(customSecurityManager);

        saxParser.parse(new File("sample.xml"), customXMLParser);

        List<String> sanitizedData = customXMLParser.getSanitizedData();
        for (String sanitized : sanitizedData) {
            System.out.println(sanitized);
        }
    }
}