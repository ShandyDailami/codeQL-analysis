import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_29492_XMLParser_A03 {

    public void parse(String filePath) {
        File inputFile = new File(filePath);

        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        SAXParserHandler handler = new SAXParserHandler();
        xmlReader.setContentHandler(handler);

        try {
            xmlReader.parse(inputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("input.xml");
    }
}