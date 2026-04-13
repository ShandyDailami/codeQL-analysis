import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_08431_XMLParser_A03 {

    public static void parse(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile.toURI().toURL().toString());

            System.out.println("Parsing finished successfully");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}