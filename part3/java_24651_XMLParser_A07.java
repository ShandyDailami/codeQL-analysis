import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24651_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
            System.out.println("Parsing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
       .
.
.
.
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}