import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_26595_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error while creating XMLReader: " + e.getMessage());
            return;
        }

        SAXParserHandler saxParserHandler = new SAXParserHandler();
        xmlReader.setContentHandler(saxParserHandler);

        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error while parsing XML file: " + e.getMessage());
            return;
        }
    }
}