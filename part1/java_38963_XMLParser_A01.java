import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_38963_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
            reader.parse(xml.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}