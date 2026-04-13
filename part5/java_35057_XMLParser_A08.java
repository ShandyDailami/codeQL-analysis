import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35057_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParser saxParser = new SAXParser();
            File xmlFile = new File("path_to_your_file.xml");
            parse(xmlFile, saxParser);
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static void parse(File xmlFile, SAXParser saxParser) throws IOException, SAXException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(saxParser);
        xmlReader.parse(xmlFile);
    }
}