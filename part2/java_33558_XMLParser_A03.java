import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

import java.io.File;
import java.io.IOException;

public class java_33558_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXDriver saxDriver = null;
        XMLReader xmlReader = null;

        try {
            saxDriver = new SAXDriver(xmlFile);
            xmlReader = XMLReaderFactory.createXMLReader();
            saxDriver.setContentHandler(xmlReader);
            xmlReader.parse(new SAXSource(saxDriver));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}