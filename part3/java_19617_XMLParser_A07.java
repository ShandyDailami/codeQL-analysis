import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.FileXMLReader;

public class java_19617_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your actual XML file path
        File xmlFileObj = new File(xmlFile);
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            FileXMLReader fileXMLReader = new FileXMLReader(xmlFileObj);
            xmlReader.setContentHandler(fileXMLReader);
            xmlReader.parse(new File(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}