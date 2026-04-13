import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;

public class java_10207_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseFile(xmlFile);
    }

    public static void parseFile(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLContentHandler());
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}