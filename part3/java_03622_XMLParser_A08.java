import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_03622_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new DefaultHandler());
            xmlReader.setEntityResolver(new DefaultHandler());
            saxReader.setContentHandler(new DefaultHandler());
            saxReader.setEntityResolver(new DefaultHandler());
            saxReader.read(xmlFile, true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}