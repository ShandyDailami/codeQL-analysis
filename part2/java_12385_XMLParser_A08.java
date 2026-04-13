import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXEventSource;

import java.io.File;
import java.io.IOException;

public class java_12385_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // Replace with your xml file path
        File xmlFileObj = new File(xmlFile);
        SAXEventSource saxEventSource = null;

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            saxEventSource = new SAXEventSource(xmlReader, xmlFileObj);

            // Define a SAXHandler to parse the XML
            saxEventSource.setContentHandler(new MyContentHandler());

            // Parse the XML
            xmlReader.parse(new SAXSource(saxEventSource));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}