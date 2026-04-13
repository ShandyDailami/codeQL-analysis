import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_33148_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new SAXContentHandler());

            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
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