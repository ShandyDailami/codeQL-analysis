import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_31377_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        File file = new File(xmlFile);

        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLContentHandler());

            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}