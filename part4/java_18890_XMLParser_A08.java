import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_18890_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml"); // replace with your file path
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXParserHandler saxParserHandler = new SAXParserHandler();
            xmlReader.setContentHandler(saxParserHandler);
            xmlReader.parse(new FileInputStream(xmlFile));

            System.out.println("XML Parsed Successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}