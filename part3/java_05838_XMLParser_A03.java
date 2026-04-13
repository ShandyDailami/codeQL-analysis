import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05838_XMLParser_A03 {

    public void parse(String filePath) {
        File xmlFile = new File(filePath);
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new EntityResolver());
        } catch (Exception e) {
            System.out.println("Could not create XMLReader: " + e.getMessage());
            return;
        }

        try {
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
       
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parse("path/to/your/xml/file.xml");
    }
}