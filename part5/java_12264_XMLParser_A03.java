import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.FileResolver;

import java.io.File;
import java.io.IOException;

public class java_12264_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new FileResolver(xmlFile.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        MyHandler handler = new MyHandler();

        try {
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File(xmlFile.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}