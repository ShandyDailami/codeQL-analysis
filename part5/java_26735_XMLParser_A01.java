import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_26735_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(xml.getAbsolutePath());
            System.out.println("Parsing completed successfully!");
        } catch (IOException e) {
            System.out.println("Failed to parse the XML file!");
            e.printStackTrace();
       
        } catch (SAXException e) {
            System.out.println("SAXException encountered while parsing XML file!");
            e.printStackTrace();
        }
    }
}