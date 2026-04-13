import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24834_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SAXParser() throws SAXException, IOException {
        File inputFile = new File("sample.xml");
        XMLReader reader = XMLReaderFactory.createXMLReader();
        XMLReaderHandler handler = new XMLReaderHandler();

        reader.setContentHandler(handler);
        reader.parse(inputFile);
    }

}