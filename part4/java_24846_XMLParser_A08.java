import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24846_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(xmlFile);

            System.out.println("Parsing completed successfully.");

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}