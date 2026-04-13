import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_21608_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "resources/sample.xml"; // Replace with your actual XML file path
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new BasicHandler());
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}