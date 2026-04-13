import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_30467_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
            System.out.println(handler.getOutput());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}