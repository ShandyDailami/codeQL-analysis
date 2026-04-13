import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37480_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // Replace with your file path

        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setEntityResolver(new SecurityEntityResolver());

            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}