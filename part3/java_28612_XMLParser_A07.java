import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_28612_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/resources/data.xml"; // Provide your XML file path
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        File xml = new File(xmlFile);
        BasicHandler handler = new BasicHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xml.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}