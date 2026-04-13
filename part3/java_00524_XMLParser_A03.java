import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_00524_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        SAXReader reader = new SAXReader();
        DefaultHandler handler = new DefaultHandler();

        try {
            XMLReader xmlReader = reader.getReader(xmlFile, handler);
            xmlReader.parse(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}