import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_21086_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();

            // Create a new handler for the SAX parser
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(xmlFile);

            // Display the parsed content
            System.out.println(handler.getContent());

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}