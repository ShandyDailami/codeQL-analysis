import java.io.File;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_39173_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Parse XML file
            saxParser.parse(new File("sample.xml"), new XmlHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler implements javax.xml.parsers.SAXHandler {
    private List<String> dataList;

    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        // Here you can perform operations related to A01_BrokenAccessControl (security-sensitive operations)
        // For example, you can add the attribute value to a list
        dataList.add(attributes.getValue("sampleData"));
    }
}