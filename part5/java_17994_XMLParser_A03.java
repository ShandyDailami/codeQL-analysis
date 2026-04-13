import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_17994_XMLParser_A03 {

    public void parseXML(String filePath) {
        File inputFile = new File(filePath);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setEntityResolver(new MyEntityResolver());
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        try {
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("XML parsing completed successfully.");
    }

    public static void main(String[] args) {
        XmlParserExample parser = new XmlParserExample();
        parser.parseXML("path_to_your_xml_file.xml");
    }
}