import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24333_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error while creating XMLReader: " + e.getMessage());
            return;
        }

        xmlReader.setContentHandler(new MyContentHandler());

        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error while parsing XML: " + e.getMessage());
            return;
        } catch (SAXException e) {
            System.out.println("Error while processing XML content: " + e.getMessage());
            return;
        }
    }
}