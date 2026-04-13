import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_34780_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // Provide your XML file path here
        SAXParserHandler saxParserHandler = new SAXParserHandler();

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParserHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}