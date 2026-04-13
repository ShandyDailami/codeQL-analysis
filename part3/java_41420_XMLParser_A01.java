import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_41420_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // replace with your xml file path

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new DefaultHandler());

            SAXParser saxParser = new SAXParser(xmlReader, new XMLHandler());
            saxParser.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}