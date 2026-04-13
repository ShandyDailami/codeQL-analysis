import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_33236_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "sample.xml"; // path to your xml file
        parseXml(xmlFilePath);
    }

    public static void parseXml(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidationMode(XMLReader.VALIDATION_STRICT);

            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error parsing XML file: " + xmlFilePath);
            e.printStackTrace();
       
        } catch (SAXException e) {
            System.err.println("Error parsing XML file: " + xmlFilePath);
            e.printStackTrace();
        }
    }
}