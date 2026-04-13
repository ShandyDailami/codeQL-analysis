import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_07123_XMLParser_A08 {

    public static void parse(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parse("path_to_your_xml_file.xml");
    }

}