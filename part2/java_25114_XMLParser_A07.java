import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_25114_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            File xmlFile = new File("path_to_your_file.xml");
            SAXHandler saxHandler = new SAXHandler();
            reader.setContentHandler(saxHandler);

            saxParser.parse(xmlFile, reader);

            System.out.println("Parsing completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}