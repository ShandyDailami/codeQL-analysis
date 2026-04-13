import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_40086_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new XmlContentHandler());

            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error while parsing the XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException while parsing the XML file: " + e.getMessage());
        }
    }
}