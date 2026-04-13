import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_31244_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/rpc", true);
            reader.setFeature("http://xml.org/sax/features/validation", true);

            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);

            System.out.println("XML Parsing Successful");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}