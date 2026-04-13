import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_03449_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/file.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXReader reader = new SAXReader();
        DefaultHandler handler = new DefaultHandler();
        try {
            XMLReader xmlReader = reader.getXMLReader(handler);
            xmlReader.parse(xmlFile);
            extractValue("element/name", handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void extractValue(String query, DefaultHandler handler) {
        try {
            String value = handler.getValue(query);
            System.out.println("Value of element '" + query + "': " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}