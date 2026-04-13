import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_06158_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "books.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            SAXReader reader = new SAXReader();
            File file = new File(xmlFile);
            XMLReader xmlReader = reader.getXMLReader(new DefaultHandler(), false);
            xmlReader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}