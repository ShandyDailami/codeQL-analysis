import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_00554_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XMLContentHandler());

            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}