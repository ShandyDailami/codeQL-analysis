import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSaxParser;
import org.xml.sax.util.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_01750_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input.xml");
        XMLParser parser = XMLReaderFactory.createXMLParser();

        // Enable error handling
        parser.setDTDHandler(new DefaultHandler());
        parser.setEntityResolver(new MyEntityResolver());

        // Parse the XML document
        try {
            parser.parse(inputFile.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}