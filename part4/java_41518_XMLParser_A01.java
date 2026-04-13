import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_41518_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "sample.xml";

        // Create an XMLReader
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        // Create a File object for the file we're reading
        File xmlFile = new File(fileName);

        // Set a ContentHandler to parse the XML file
        xmlReader.setContentHandler(new XmlHandler(xmlFile));

        // Parse the XML file
        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}