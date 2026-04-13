import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37829_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";

        File xmlFile = new File(xmlFilePath);

        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new CustomEntityResolver());

            XmlParserHandler handler = new XmlParserHandler();
            xmlReader.setContentHandler(handler);

            xmlReader.parse(xmlFile);

            System.out.println("Parsing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}