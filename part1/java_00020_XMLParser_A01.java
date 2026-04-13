import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_00020_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String xmlFilePath = "invalid.xml"; // provide an invalid XML file
            File xmlFile = new File(xmlFilePath);
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler();
            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader(defaultHandler);

            saxParser.parse(xmlFile, xmlReader);
            System.out.println("Invalid XML document");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}