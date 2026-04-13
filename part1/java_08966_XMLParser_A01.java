import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_08966_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (ParserConfigurationException e) {
            System.out.println("Failed to create an XML reader");
            return;
        }

        SAXHandler handler = new SAXHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(inputFile);
        } catch (SAXException e) {
            System.out.println("Failed to parse the XML file");
            return;
        } catch (IOException e) {
            System.out.println("Failed to read the XML file");
            return;
        }

        System.out.println("Element Names and Attributes:");
        handler.printElements();
    }
}