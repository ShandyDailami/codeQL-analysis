import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_03164_XMLParser_A08 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        File xmlFile = new File("path_to_your_xml_file");

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XMLContentHandler());
            xmlReader.setErrorHandler(new XMLErrorHandler());
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