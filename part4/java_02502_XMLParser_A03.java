import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_02502_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        XMLReader xmlReader = null;
        BasicHandler handler = new BasicHandler();

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile.toURI().toString());

            System.out.println("XML Parsed Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}