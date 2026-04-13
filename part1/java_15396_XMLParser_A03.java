import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_15396_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        BasicHandler handler = new BasicHandler();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // The handler will now have parsed the XML and data is accessible in the handler.
        // You can access data using get methods like handler.getNodeValue("xpath_to_data")
    }
}