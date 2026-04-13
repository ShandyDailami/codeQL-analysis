import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_09618_XMLParser_A03 {
    private static final String XML_FILE = "sample.xml"; // replace with your file path

    public static void main(String[] args) {
        File file = new File(XML_FILE);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        SaxHandler saxHandler = new SaxHandler();
        saxParser.parse(file, saxHandler);
    }
}