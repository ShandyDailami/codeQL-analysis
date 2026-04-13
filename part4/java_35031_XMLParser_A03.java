import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35031_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");

        SAXParserHandler saxParserHandler = new SAXParserHandler();

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParserHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}