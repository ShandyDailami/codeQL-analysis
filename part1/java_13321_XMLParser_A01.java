import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13321_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Define the handler
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            // Parse the file
            reader.parse(xmlFile);

            // Print the parsed data
            for (String data : handler.getData()) {
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}