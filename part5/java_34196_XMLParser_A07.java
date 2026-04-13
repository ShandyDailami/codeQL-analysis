import com.iceberg.xml.StreamParser;
import com.iceberg.xml.XMLException;
import com.iceberg.xml.SAXParser;

public class java_34196_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParser parser = new SAXParser();
            StreamParser streamParser = new StreamParser();

            // Load the XML file
            parser.parse(XMLParserExample.class.getResourceAsStream("/example.xml"),
                    new XMLHandler(streamParser));

            // Clean up
            streamParser.endDocument();
            streamParser.getDocument().close();
            streamParser.getParser().close();
        } catch (XMLException e) {
            e.printStackTrace();
        }
    }
}