import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_18235_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your actual file path
        File xmlFile = new File(xmlFilePath);

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.setEntityResolver(new CustomEntityResolver());

            SAXParserHandler saxParserHandler = new SAXParserHandler();
            xmlReader.setContentHandler(saxParserHandler);

            xmlReader.parse(xmlFile);

            System.out.println("Parsing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}