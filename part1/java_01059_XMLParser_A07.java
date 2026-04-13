import java.io.File;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_01059_XMLParser_A07 {
    public static void main(String[] args) {
        // Setup SAXParser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // Setup DefaultHandler to handle errors
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void error(SAXException e) {
                System.out.println("Error in parsing XML: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXException e) {
                System.out.println("Fatal error in parsing XML: " + e.getMessage());
            }

            @Override
            public void warning(SAXException e) {
                System.out.println("Warning in parsing XML: " + e.getMessage());
            }
        };

        // Parse XML
        try {
            saxParser.parse(new File("authfailures.xml"), defaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}