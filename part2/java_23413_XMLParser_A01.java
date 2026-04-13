import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_23413_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            reader.parse(xml);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}