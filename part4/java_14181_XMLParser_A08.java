import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_14181_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new BasicHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}