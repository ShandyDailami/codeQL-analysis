import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class java_22543_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader xmlReader = null;
        DefaultHandler defaultHandler = new DefaultHandler();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            xmlReader = saxParserFactory.newSAXParser(true).getXMLReader();
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.setContentHandler(defaultHandler);
            }
        }
    }
}