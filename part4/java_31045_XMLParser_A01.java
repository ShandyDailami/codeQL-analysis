import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_31045_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();

            // Create an instance of the handler
            XmlHandler handler = new XmlHandler();

            // Set the handler for the XMLReader
            xmlReader.setContentHandler(handler);

            // Parse the XML file
            xmlReader.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}