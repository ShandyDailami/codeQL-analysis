import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_18715_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlContentHandler());
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error while reading XML file.");
        } catch (SAXException e) {
            System.out.println("Error while parsing XML file.");
        }
    }
}