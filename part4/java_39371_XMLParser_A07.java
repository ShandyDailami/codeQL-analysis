import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39371_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourXmlFile.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new AuthFailureContentHandler());
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}